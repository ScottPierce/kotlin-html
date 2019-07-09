enableFeaturePreview("GRADLE_METADATA")

rootProject.name = "kotlin-html"

include(
    ":kotlin-html",
    ":kotlin-html-ktor",
    ":kotlin-html-generator",
    ":benchmark"
)
