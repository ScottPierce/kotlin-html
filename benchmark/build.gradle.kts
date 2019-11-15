plugins {
    id("org.jetbrains.kotlin.multiplatform")
}

repositories {
    mavenLocal()
}

kotlin {
    jvm()
    macosX64 {
        binaries {
            executable {
            }
        }
    }
    linuxX64 {
        binaries {
            executable {
            }
        }
    }

    @Suppress("UNUSED_VARIABLE")
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":kotlin-html-writer"))
                implementation(Libs.kotlin.stdlib.common)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(Libs.kotlin.stdlib.jvm)
                implementation(Libs.kotlinx.html)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(Libs.kotlin.test.jvm)
            }
        }

        val macosX64Main by getting {
            dependencies {
                implementation(Libs.kotlinx.coroutines.native)
            }
        }

        val linuxX64Main by getting {
        }
    }
}
