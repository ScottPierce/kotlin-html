import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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
    js()
    macosX64()

    @Suppress("UNUSED_VARIABLE")
    sourceSets {
        val commonMain by getting {
            kotlin.srcDirs(
                project.file("src/commonMain/kotlin"),
                project.file("src/genMain/kotlin")
            )

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

        val genTest by creating {
            dependsOn(commonMain)

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

        val jvmTest by getting {
            dependsOn(genTest)
            
            dependencies {
                implementation(Libs.kotlin.test.jvm)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(Libs.kotlin.stdlib.js)
            }
        }

        val jsTest by getting {
            dependsOn(genTest)

            dependencies {
                implementation(Libs.kotlin.test.js)
            }
        }
    }
}

tasks.withType(KotlinCompile::class)
    .forEach {
        it.kotlinOptions {
            freeCompilerArgs = listOf(
                "-Xnew-inference",
                "-XXLanguage:+InlineClasses"
            )
        }
    }

tasks.register<JacocoReport>("jvmCodeCoverageReport") {
    executionData(tasks.getByName("jvmTest"))

    sourceDirectories.setFrom(
        "src/commonMain/kotlin",
        "src/genMain/kotlin"
    )

    classDirectories.setFrom(
        "build/classes/kotlin/jvm/main/dev/scottpierce/html/style",
        "build/classes/kotlin/jvm/main/dev/scottpierce/html/write"
        // Excluding dev.scottpierce.html.element package, even though we have almost 100% test coverage
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
