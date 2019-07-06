plugins {
    id("org.jetbrains.kotlin.jvm")
    `maven-publish`
}

dependencies {
    implementation(project(":kotlin-html"))

    implementation(Libs.kotlin.stdlib.jvm)
    implementation(Libs.ktorServerCore)
}
