plugins {
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    implementation(project(":kotlin-html"))
    implementation(Libs.kotlin.stdlib.jvm)
    implementation(Libs.kotlinx.html)

    testImplementation(Libs.kotlin.test.jvm)
}
