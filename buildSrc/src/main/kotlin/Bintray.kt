import org.gradle.api.publish.PublishingExtension
import org.gradle.kotlin.dsl.maven

fun PublishingExtension.configureBintray() {
    repositories.maven("https://api.bintray.com/maven/scottpierce/maven/kotlin-html/;publish=0") {
        name = "bintray"

        credentials {
            username = System.getenv("BINTRAY_USER")
            password = System.getenv("BINTRAY_KEY")
        }
    }
}
