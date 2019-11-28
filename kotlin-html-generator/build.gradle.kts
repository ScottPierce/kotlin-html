plugins {
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    implementation(Deps.kotlin.stdlib.jvm)
    implementation(Deps.kotlinPoet)
    implementation(Deps.kotlinx.coroutines.jvm)
}
