import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("maven-publish")
    id("signing")
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    js()

    @Suppress("UNUSED_VARIABLE")
    sourceSets {
        commonMain {
            dependencies {
                implementation(Libs.kotlin.stdlib.common)
            }
        }

        commonTest {
            dependencies {
                for (lib in Libs.kotlin.test.common) {
                    implementation(lib)
                }
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(Libs.kotlin.stdlib.jvm)
            }
        }

//        jvm {
//            compilations["main"].defaultSourceSet.dependencies {
//                api(kotlin("stdlib-jdk8"))
//            }
//            compilations["test"].defaultSourceSet.dependencies {
//                implementation(kotlin("test-junit"))
//            }
//        }
    }
}
