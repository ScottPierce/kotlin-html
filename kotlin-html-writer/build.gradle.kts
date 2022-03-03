plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("jacoco")
    `maven-publish`
}

publishing.configureBintray()

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    js {
        browser()
        nodejs()
    }
    macosX64()

    @Suppress("UNUSED_VARIABLE")
    sourceSets {
        val commonMain by getting {
            kotlin.srcDirs(
                project.file("src/commonMain/kotlin"),
                project.file("src/genMain/kotlin")
            )

            dependencies {
                implementation(Deps.kotlin.stdlib.common)
            }
        }

        val commonTest by getting {
            dependencies {
                for (lib in Deps.kotlin.test.common) {
                    implementation(lib)
                }
            }
        }

        val genTest by creating {
            dependsOn(commonMain)

            dependencies {
                for (lib in Deps.kotlin.test.common) {
                    implementation(lib)
                }
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(Deps.kotlin.stdlib.jvm)
            }
        }

        val jvmTest by getting {
            dependsOn(jvmMain)
            dependsOn(genTest)

            dependencies {
                implementation(Deps.kotlin.test.jvm)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(Deps.kotlin.stdlib.js)
            }
        }

        val jsTest by getting {
            dependsOn(jsMain)
            dependsOn(genTest)

            dependencies {
                implementation(Deps.kotlin.test.js)
            }
        }

//        val macosX64Main by getting {
//        }
//
//        val macosX64Test by getting {
//            dependsOn(macosX64Main)
//        }
//
//        val linuxX64Main by getting {
//        }
//
//        val linuxX64Test by getting {
//            dependsOn(linuxX64Main)
//        }
    }
    sourceSets {
        all {
            languageSettings.enableLanguageFeature("InlineClasses")
        }
    }
}

tasks.register<JacocoReport>("jvmCodeCoverageReport") {
    executionData(tasks.getByName("jvmTest"))

    sourceDirectories.setFrom(
        "src/commonMain/kotlin",
        "src/genMain/kotlin",
        "src/jvmMain/kotlin"
    )

    classDirectories.setFrom(
        "build/classes/kotlin/jvm/main/dev/scottpierce/html/writer/style",
        "build/classes/kotlin/jvm/main/dev/scottpierce/html/writer/element"
        // Excluding dev.scottpierce.html.writer.element package, even though we have almost 100% test coverage
        // because of https://github.com/jacoco/jacoco/issues/654
    )

    @Suppress("UnstableApiUsage")
    reports {
        csv.isEnabled = false
        xml.isEnabled = true
        xml.destination = file("${rootProject.buildDir}/jacoco/kotlin-html-jvm.xml")
        html.isEnabled = true
        html.destination = file("$buildDir/jacocoHtml")
    }
}

kotlin.sourceSets.map {
    it.apply {
        languageSettings.apply {
            useExperimentalAnnotation("kotlin.time.ExperimentalTime")
        }
    }
}
