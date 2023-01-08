import org.jetbrains.kotlin.cli.common.toBooleanLenient
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath(Plugins.kotlin)
        classpath(Plugins.gradleMavenPublish)
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
    }

    plugins.withId("maven-publish") {
        extensions.getByType<PublishingExtension>().apply {
            repositories {
                maven {
                    name = "GitHubPackages"
                    url = uri("https://maven.pkg.github.com/ScottPierce/kotlin-html")
                    credentials {
                        username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                        password = project.findProperty("gpr.token") as String? ?: System.getenv("TOKEN")
                    }
                }
            }
        }
    }

    plugins.withId("org.jetbrains.kotlin.multiplatform") {
        configure<org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension> {
            sourceSets.configureEach {
                languageSettings.apply {
                    optIn("kotlin.time.ExperimentalTime")
                }
            }
        }
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
