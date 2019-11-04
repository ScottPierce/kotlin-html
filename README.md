[![CircleCI](https://circleci.com/gh/ScottPierce/kotlin-html/tree/master.svg?style=svg)](https://circleci.com/gh/ScottPierce/kotlin-html/tree/master)
[![jcenter](https://api.bintray.com/packages/scottpierce/maven/kotlin-html/images/download.svg?version=0.3.0)](https://bintray.com/beta/#/scottpierce/maven/kotlin-html/0.3.0?tab=overview)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.3.50-green.svg)](https://kotlinlang.org/)
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-green.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)
<!---
This entire library is inline functions, and Jacoco doesn't show inline functions code coverage correctly: https://github.com/jacoco/jacoco/issues/654
[![codecov](https://codecov.io/gh/ScottPierce/kotlin-html/branch/master/graph/badge.svg)](https://codecov.io/gh/ScottPierce/kotlin-html)
-->

## JVM Usage
```Kotlin
repositories {
    jcenter()
}

dependencies {
    // JVM version of the HTML library
    implementation("dev.scottpierce.kotlin-html:kotlin-html-writer-jvm:0.3.0")
    
    // If you are using Ktor, you can use this as well
    implementation("dev.scottpierce.kotlin-html:kotlin-html-ktor:0.3.0")
}
```

## Multiplatform Usage
```Kotlin
repositories {
    jcenter()
}

kotlin {
    commonMain {
        dependencies {
            implementation("dev.scottpierce.kotlin-html:kotlin-html-writer:0.3.0")
        }    
    }
}
```

## Should I use this Library?
**You should only use this library if you are comfortable with the following:**
* Potential API Changes - Until 1.0 the API is potentially unstable
* Missing HTML Elements / Style Properties - Until this library hits 1.0 there is a good chance there are missing html elements that you
need. You may need to contribute a PR or two. I'll do my best to be responsive and won't let a PR sit for weeks.
    * If you add an element, please make sure you add it via the generator module
        * Add an [Element](./kotlin-html/blob/master/kotlin-html-generator/src/main/kotlin/dev/scottpierce/html/generate/model/Element.kt)
        * Add a [Style Property](./kotlin-html/blob/master/kotlin-html-generator/src/main/kotlin/dev/scottpierce/html/generate/model/StyleProperty.kt)
* You don't need a read / introspection API for the DOM.
    * Reading the DOM, and making decisions in your algorithm based 
    on previously added elements is an anti-pattern that leads to unmaintainable code. Instead, you should establish a model
    containing all the data your html creation algorithm needs, and then create your HTML based on the information in that 
    model

## Features
* HTML DSL
    * Explicit support for common html attributes in element functions for a cleaner api (i.e. id, classes, and attr)
    * Lightweight streaming API
        * Doesn't create a lot of unnecessary objects to represent the DOM. i.e. DOM introspection isn't possible
* Style DSL
    * Allows inlining style to the header or individual elements
    * CSS
* Multi-platform
* Integration with [Ktor](https://ktor.io/)
* Simple Architecture - easy to understand and contribute to, especially relative to kotlinx.html
    
## Pull Requests Welcome
* If the HTML element or CSS Property you need doesn't exist, you can add it yourself via the generation module, 
or you can create an issue
* Please create an issue to discuss any major changes / refactors

## Why does this library exist when kotlinx.html exists?
There is a need for a simple Kotlin HTML templating DSL. kotlinx.html exposes an API that can be a little clunky at 
times, lacks features that many users need (i.e. styles), and lacks features that many users want. 
The community filed issues for some of these issues [years ago](https://github.com/Kotlin/kotlinx.html/issues/31), 
and no progress had been made. The values and goals of this library differentiate enough that it constituted a fresh 
start instead of attempting contribution.

# Basic Sample
```Kotlin
fun main() {
    // Choose a HtmlWriter implementation. StringBuilderHtmlWriter is good for testing.
    val writer: HtmlWriter = StringBuilderHtmlWriter(options = WriteOptions.default)

    // Writes the main page to the HtmlWriter
    writer.mainPage()

    // Prints out the written page
    println(writer)
}

fun HtmlWriter.mainPage() {
    docType(DocType.Html)
    html {
        head {
            styleSheet {
                style("body") {
                    margin = 0.px
                    padding = 0.px
                    color = color(100, 100, 100)
                }
                style(".class2") {
                    background = color("#555555")
                }
            }
        }
        body {
            navigation()
            aboutSection()
            footer()
        }
    }
}

fun BodyContext.navigation() {
    div(
        id = "navigation",
        style = {
            // Inline style here
            margin = 1.rem
        }
    ) {
        // Navigation HTML here
    }
}

fun BodyContext.aboutSection() {
    section(id = "about", classes = "class1 class2") {
        // About section HTML here
    }
}

fun BodyContext.footer() {
    span(style = { /* Inline span style here */ }) {
        +"Footer Text"
    }
}
```

## Integration with Ktor
``` Kotlin
dependencies {
    implementation("dev.scottpierce.kotlin-html:kotlin-html-ktor:0.3.0")
}
```

You can use the extension function `respondHtml` to write HTML as a response
```Kotlin
fun Application.mainModule() {
    routing {
        get("ktor-sample") {
            call.respondHtml {
                head {
                    title("Ktor Sample")
                    metaDescription("This is a Ktor sample")
                }
                
                body {
                    +"Ktor Sample"
                }
            }
        }
    }
}
```

# Benchmark
![kotlin-html vs kotlinx.html benchmark](https://docs.google.com/spreadsheets/d/e/2PACX-1vSzaUiakNFkWywUTO63oSOg1uMoHrs62wju4oDyzeAcK7RsPfyuS4S7OsVp7sba007QVYf3GoE0nA9j/pubchart?oid=492427110&format=image)

\<Insert obligatory disclaimer about microbenchmarks here\>

**kotlin-html (this library) averaged 457 millis to create a page of ~7700 characters 100k times, and kotlinx.html 
stream averaged 1186 millis to create the same page page 100k times. That means that kotlin-html enjoys 2.6X performance 
improvement over kotlinx.html in this test case.**
 
The test was performed by creating the same html page in kotlin-html and kotlinx.html, and then running the page creation 100k 
times. Each test was run 50 times for warmup, and then 50 iterations to get an average. The reality is that both of the 
libraries are fast enough that performance doesn't really matter for a normal use-case.

[See the Benchmark Code](./benchmark/src/main/kotlin/dev/scottpierce/html/benchmark/ThreadedBenchmark.kt)<br>
[raw benchmark data](https://docs.google.com/spreadsheets/d/1Yx_RiqxU4Hm9MxfH71YqVj2fiklrUqYSDkiiFVbBKis/edit?usp=sharing)

Benchmark Device:
<pre>
JDK 12.0.1
2018 MacBook Pro 15"
2.9 GHz Intel Core i9
32 GB Memory
</pre>
