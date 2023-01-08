plugins {
    kotlin("multiplatform")
    `maven-publish`
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    js {
        browser {
            testTask {
                useKarma {
                    useChrome()
                }
            }
        }
        nodejs()
    }

    @Suppress("UNUSED_VARIABLE")
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":kotlin-html-style-builder"))
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
    }
}

