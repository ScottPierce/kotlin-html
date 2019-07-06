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

    val fullPath = "${rootProject.name}${project.path.replace(":", "-")}"

    afterEvaluate {
        tasks.withType<Jar> {
            // set jar base names to module paths, like strife-core and strife-samples-embeds
            archiveBaseName.set(fullPath)
        }
    }

    // will only run in subprojects with the maven-publish plugin already applied
    pluginManager.withPlugin("maven-publish") {
        publishing.configureBintray()

        afterEvaluate {
            publishing.publications.filterIsInstance<MavenPublication>().forEach {
                // replace project names in artifact with their module paths, ie core-jvm becomes strife-core-jvm
                it.artifactId = it.artifactId.replace(name, fullPath)
            }
        }
    }
}
