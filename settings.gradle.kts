enableFeaturePreview("GRADLE_METADATA")

rootProject.name = "kotlin-html"

include(
    ":kotlin-html-writer",
    ":kotlin-html-ktor",
    ":kotlin-html-style-builder",
    ":kotlin-html-generator",
    ":benchmark"
)
