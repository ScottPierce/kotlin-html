plugins {
    id("org.jetbrains.kotlin.jvm")
    `maven-publish`
}

dependencies {
    implementation(project(":kotlin-html-writer"))

    implementation(Deps.kotlin.stdlib.jvm)
    implementation(Deps.ktorServerCore)
}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.getByName("main").allSource)
}
