plugins {
    id("org.jetbrains.kotlin.jvm")
    `maven-publish`
    id("com.jfrog.bintray") version "1.8.4"
}

dependencies {
    implementation(project(":kotlin-html"))

    implementation(Libs.kotlin.stdlib.jvm)
    implementation(Libs.ktorServerCore)
}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.getByName("main").allSource)
}

val pomUrl = "https://github.com/ScottPierce/kotlin-html/"
val pomScmUrl = "https://github.com/ScottPierce/kotlin-html/"
val pomIssueUrl = "https://github.com/ScottPierce/kotlin-html/"
val pomDesc = "A Kotlin Multiplatform DSL for HTML and CSS"
val pomScmConnection = "scm:git:git://github.com/ScottPierce/kotlin-html.git"
val pomScmDevConnection = "scm:git:git://github.com/ScottPierce/kotlin-html.git"

val githubRepo = "https://github.com/ScottPierce/kotlin-html/"
val githubReadme = "https://github.com/ScottPierce/kotlin-html/README.md"

val pomLicenseName = "The Apache Software License, Version 2.0"
val pomLicenseUrl = "http://www.apache.org/licenses/LICENSE-2.0.txt"
val pomLicenseDist = "repo"

val pomDeveloperId = "ScottPierce"
val pomDeveloperName = "Scott Pierce"

publishing {
    publications {
        create<MavenPublication>("lib") {
            groupId = group.toString()
            artifactId = "kotlin-html-ktor"
            version = project.version.toString()
            from(components["java"])
            artifact(sourcesJar)

            pom.withXml {
                asNode().apply {
                    appendNode("description", pomDesc)
                    appendNode("name", rootProject.name)
                    appendNode("url", pomUrl)
                    appendNode("licenses").appendNode("license").apply {
                        appendNode("name", pomLicenseName)
                        appendNode("url", pomLicenseUrl)
                        appendNode("distribution", pomLicenseDist)
                    }
                    appendNode("developers").appendNode("developer").apply {
                        appendNode("id", pomDeveloperId)
                        appendNode("name", pomDeveloperName)
                    }
                    appendNode("scm").apply {
                        appendNode("url", pomScmUrl)
                        appendNode("connection", pomScmConnection)
                    }
                }
            }
        }
    }
}

bintray {
    // Getting bintray user and key from properties file or command line
    user = System.getenv("BINTRAY_USER")
    key = System.getenv("BINTRAY_KEY")

    // Automatic publication enabled
    publish = true

    // Set maven publication onto bintray plugin
    setPublications("lib")

    // Configure package
    pkg.apply {
        repo = "maven"
        userOrg = "scottpierce"
        name = rootProject.name

        vcsUrl = "https://github.com/ScottPierce/kotlin-html.git"
        websiteUrl = "https://github.com/ScottPierce/kotlin-html"
        issueTrackerUrl = "https://github.com/ScottPierce/kotlin-html"

        // Configure version
        version.apply {
            name = project.version.toString()
            vcsTag = project.version.toString()
        }
    }
}
