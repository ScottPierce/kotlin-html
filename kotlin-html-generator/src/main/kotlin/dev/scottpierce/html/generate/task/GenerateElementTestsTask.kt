package dev.scottpierce.html.generate.task

import dev.scottpierce.html.generate.Task
import dev.scottpierce.html.generate.model.Constants
import dev.scottpierce.html.generate.model.Element
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import java.io.File

class GenerateElementTestsTask : Task {
    companion object {
        private val BASE_TEMPLATE_DIR = File("kotlin-html/src/commonAndGenTest/kotlin/dev/scottpierce/html/element")
        private val TEMPLATE_NORMAL_FILE = File("$BASE_TEMPLATE_DIR/DivTest.kt")
        private val TEMPLATE_VOID_FILE = File("$BASE_TEMPLATE_DIR/BrTest.kt")
    }

    override val name: String = "Generate Element Tests"

    override suspend fun execute() {
        val deleteJob: Job = GlobalScope.launch(Dispatchers.IO) {
            File("${Constants.BASE_GEN_TEST_DIR}/dev/scottpierce/html/element/").deleteRecursively()
        }

        val normalTemplateDeferred: Deferred<String> = GlobalScope.async {
            TEMPLATE_NORMAL_FILE.bufferedReader().readText()
        }

        val voidTemplateDeferred: Deferred<String> = GlobalScope.async {
            TEMPLATE_VOID_FILE.bufferedReader().readText()
        }

        val normalTemplate: String = normalTemplateDeferred.await()
        val voidTemplate: String = voidTemplateDeferred.await()
        deleteJob.join()

        val writeFileJobs = mutableListOf<Job>()

        elementLoop@ for (i in Element.values.indices) {
            val element = Element.values[i]

            // These are the template tests. Generating them again would be duplicate
            when (element.tagName) {
                "div", "br" -> continue@elementLoop
            }

            val capitalizedTag = element.tagName.capitalize()

            val testString: String = when (element) {
                is Element.Normal -> {
                    normalTemplate
                        .replace("Div", capitalizedTag)
                        .replace("div", element.tagName)
                        .replace("BodyContext", element.callingContext.contextClassName.simpleName)
                }

                is Element.Void -> {
                    voidTemplate
                        .replace("Br", capitalizedTag)
                        .replace("br", element.tagName)
                        .replace("BodyContext", element.callingContext.contextClassName.simpleName)
                }
            }

            writeFileJobs += GlobalScope.launch(Dispatchers.IO) {
                File("${Constants.BASE_GEN_TEST_DIR}/dev/scottpierce/html/element/${capitalizedTag}Test.kt").apply {
                    parentFile.mkdirs()
                    createNewFile()
                }.bufferedWriter().use {
                    it.write(testString)
                }
            }
        }

        writeFileJobs.joinAll()
    }
}
