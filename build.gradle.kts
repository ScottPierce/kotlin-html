import org.jetbrains.kotlin.cli.common.toBooleanLenient
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath(Plugins.kotlin)
    }
}

val isCi = System.getenv("CI").toBooleanLenient() ?: false

apply {
    from(project.file("./gradle/ktlint.gradle"))
}

val versionString = if (isCi && System.getenv().containsKey("CIRCLE_TAG")) {
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
        jcenter()
        maven {
            url = uri("https://dl.bintray.com/kotlin/kotlinx.html/")
        }
        maven {
            url = uri("https://kotlin.bintray.com/ktor")
            content {
                includeGroup("io.ktor")
            }
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}

tasks.create("updateVersionInDocumentation") {
    doLast {
        val readMeFile = File("README.md")

        val readMeString = readMeFile.bufferedReader().readText()
        val updatedReadMe = readMeString.replace(Regex("[0-9]+\\.[0-9]+\\.[0-9]+"), versionString)

        if (readMeString == updatedReadMe) {
            println("README had no changes")
        } else {
            println("README has changes")
        }

        readMeFile.bufferedWriter().use {
            it.write(updatedReadMe)
        }
    }
}
