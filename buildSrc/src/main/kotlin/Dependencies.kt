object Versions {
    const val kotlin = "1.3.50"
    const val ktor = "1.2.2"
}

object Plugins {
    val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Libs {
    val kotlin = KotlinDeps()
    val kotlinx = KotlinxDeps()
    val kotlinPoet = "com.squareup:kotlinpoet:1.4.3"
    val ktorServerCore = "io.ktor:ktor-server-core:${Versions.ktor}"
    val okio = "com.squareup.okio:okio:2.2.2"
}

class KotlinDeps internal constructor() {
    val stdlib = KotlinStdLibLibs()
    val test = KotlinTestLibs()
}

class KotlinStdLibLibs internal constructor() {
    val common = "org.jetbrains.kotlin:kotlin-stdlib-common:${Versions.kotlin}"
    val jvm = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    val js = "org.jetbrains.kotlin:kotlin-stdlib-js:${Versions.kotlin}"
}

class KotlinTestLibs internal constructor() {
    val common: List<String> = listOf(
        "org.jetbrains.kotlin:kotlin-test-common:${Versions.kotlin}",
        "org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.kotlin}"
    )

    val jvm = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    val js = "org.jetbrains.kotlin:kotlin-test-js:${Versions.kotlin}"
}

class KotlinxDeps internal constructor() {
    val coroutines = CoroutineDeps()
    val html = "org.jetbrains.kotlinx:kotlinx-html-jvm:0.6.12"
}

class CoroutineDeps internal constructor() {
    val jvm = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.0-M2"
}
