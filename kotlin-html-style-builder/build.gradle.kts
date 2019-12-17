plugins {
    id("org.jetbrains.kotlin.multiplatform")
    `maven-publish`
}

publishing.configureBintray()

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    js()
    macosX64()
    linuxX64()

    @Suppress("UNUSED_VARIABLE")
    sourceSets {
        val commonMain by getting {
            kotlin.srcDirs(
                project.file("src/commonMain/kotlin"),
                project.file("src/genMain/kotlin")
            )

            dependencies {
                api(project(":kotlin-html-writer"))
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

        val jvmMain by getting {
            dependencies {
                implementation(Deps.kotlin.stdlib.jvm)
            }
        }

        val jvmTest by getting {
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
            dependencies {
                implementation(Deps.kotlin.test.js)
            }
        }

        val macosX64Main by getting {
        }

        val macosX64Test by getting {
            dependsOn(macosX64Main)
        }

        val linuxX64Main by getting {
        }

        val linuxX64Test by getting {
            dependsOn(linuxX64Main)
        }

        all {
            languageSettings.enableLanguageFeature("InlineClasses")
        }
    }
}
