plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("jacoco")
    id("maven-publish")
    id("signing")
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }

    @Suppress("UNUSED_VARIABLE")
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Libs.kotlin.stdlib.common)
            }
        }

        val commonTest by getting {
            dependencies {
                for (lib in Libs.kotlin.test.common) {
                    implementation(lib)
                }
            }
        }

        val genMain = create("genMain") {
            dependsOn(getByName("commonMain"))
        }

        val commonAndGenTest = create("commonAndGenTest") {
            dependsOn(commonTest)
            dependsOn(genMain)

            dependencies {
                for (lib in Libs.kotlin.test.common) {
                    implementation(lib)
                }
            }
        }

        val jvmMain by getting {
            dependsOn(genMain)

            dependencies {
                implementation(Libs.kotlin.stdlib.jvm)
            }
        }

        val jvmTest by getting {
            dependsOn(commonAndGenTest)

            dependencies {
                implementation(Libs.kotlin.test.jvm)
            }
        }
    }
}

tasks.register<JacocoReport>("jvmCodeCoverageReport") {
    executionData(tasks.getByName("jvmTest"))

    sourceDirectories.setFrom(
        "src/commonMain/kotlin"
    )
    
    classDirectories.setFrom(
        "build/classes/kotlin/jvm/main"
    )

    @Suppress("UnstableApiUsage")
    reports {
        csv.isEnabled = false
        xml.isEnabled = true
        xml.destination = file("${rootProject.buildDir}/jacoco/html-builder-jvm.xml")
        html.isEnabled = true
        html.destination = file("${buildDir}/jacocoHtml")
    }
}
