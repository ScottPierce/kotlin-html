import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath(Plugins.kotlin)
    }
}

allprojects {
    group = "dev.scottpierce.html"
    version = "0.1.0"
}

subprojects {
    repositories {
        mavenCentral()
        jcenter()

        maven {
            url = uri("https://dl.bintray.com/kotlin/kotlinx.html/")
            content {
                includeModule("org.jetbrains.kotlinx", "kotlinx-html")
                includeModule("org.jetbrains.kotlinx", "kotlinx-html-jvm")
            }
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
