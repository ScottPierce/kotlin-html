plugins {
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    implementation(Libs.kotlin.stdlib.jvm)
    implementation(Libs.kotlinPoet)
    implementation(Libs.kotlinx.coroutines.jvm)
}
