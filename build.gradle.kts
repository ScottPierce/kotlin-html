import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `maven-publish`
}

buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath(Plugins.kotlin)
    }
}

apply {
    from(project.file("./gradle/ktlint.gradle"))
}

allprojects {
    group = "dev.scottpierce.kotlin-html"
    version = "0.1.0"
}

subprojects {
    repositories {
        maven {
            url = uri("https://dl.bintray.com/kotlin/kotlinx.html/")
        }
        jcenter()
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

    // will only run in subprojects with the maven-publish plugin already applied
    pluginManager.withPlugin("maven-publish") {
        publishing.configureBintray()
    }
}
