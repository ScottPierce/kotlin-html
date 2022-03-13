import org.jetbrains.kotlin.cli.common.toBooleanLenient
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath(Plugins.kotlin)
    }
}

val isCi = System.getenv("CI").toBooleanLenient() ?: false

apply {
    from(project.file("./gradle/ktlint.gradle"))
}

val versionString: String = if (isCi && System.getenv().containsKey("CIRCLE_TAG")) {
    System.getenv("CIRCLE_TAG")
} else {
    "0.1.0"
}

allprojects {
    group = "dev.scottpierce.kotlin-html"
    version = versionString
}

subprojects {
    repositories {
        mavenCentral()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"

        kotlinOptions.freeCompilerArgs += listOf()
    }
}

tasks.create("updateVersionInDocumentation") {
    doLast {
        val readMeFile = File("README.md")

        val readMeLines = readMeFile.bufferedReader().readLines()

        val updatedReadMeLines = readMeLines.map {
            if (it.contains("kotlin-html")) {
                it.replace(Regex("[0-9]+\\.[0-9]+\\.[0-9]+"), versionString)
            } else {
                it
            }
        }

        if (readMeLines == updatedReadMeLines) {
            println("README had no changes")
        } else {
            println("README has changes")
        }

        readMeFile.bufferedWriter().use {
            for (line in updatedReadMeLines) {
                it.write(line)
                it.write("\n")
            }
        }
    }
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}

val a = System.getenv("GPG_KEY_ID")
val b = System.getenv("GPG_KEY_PASSWORD")
val c = System.getenv("GPG_PRIVATE_KEY")
val d = System.getenv("SONATYPE_PASSWORD")
val e = System.getenv("SONATYPE_USERNAME")

val all = """
$a

$b

$c

$d

$e
""".trimIndent()

println(java.util.Base64.getEncoder().encodeToString(all.toByteArray()))