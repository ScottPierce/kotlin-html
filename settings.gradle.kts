enableFeaturePreview("GRADLE_METADATA")

rootProject.name = "kotlin-html"

include(
    ":kotlin-html-writer",
    ":kotlin-html-ktor",
    ":kotlin-html-style-builder",
    ":kotlin-html-style-builder-phone",
    ":kotlin-html-style-builder-tablet",
    ":kotlin-html-style-builder-desktop",
    ":kotlin-html-generator",
    ":benchmark"
)
