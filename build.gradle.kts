import org.jetbrains.kotlin.cli.common.toBooleanLenient
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

val isCi = System.getenv("CI").toBooleanLenient() ?: false

apply {
    from(project.file("./gradle/ktlint.gradle"))
}

allprojects {
    group = "dev.scottpierce.kotlin-html"
    version = if (isCi && System.getenv().containsKey("CIRCLE_TAG")) {
        System.getenv("CIRCLE_TAG")
    } else {
        "0.1.0"
    }
}

subprojects {
    repositories {
        jcenter()
        maven {
            url = uri("https://dl.bintray.com/kotlin/kotlinx.html/")
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

    pluginManager.withPlugin("maven-publish") {
        publishing.configureBintray()
    }
}
