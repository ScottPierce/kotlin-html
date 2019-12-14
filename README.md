[![CircleCI](https://circleci.com/gh/ScottPierce/kotlin-html/tree/master.svg?style=svg)](https://circleci.com/gh/ScottPierce/kotlin-html/tree/master)
[![jcenter](https://api.bintray.com/packages/scottpierce/maven/kotlin-html/images/download.svg?version=0.5.7)](https://bintray.com/beta/#/scottpierce/maven/kotlin-html/0.5.7?tab=overview)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.3.60-green.svg)](https://kotlinlang.org/)
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-green.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)
<!---
This entire library is inline functions, and Jacoco doesn't show inline functions code coverage correctly: https://github.com/jacoco/jacoco/issues/654
[![codecov](https://codecov.io/gh/ScottPierce/kotlin-html/branch/master/graph/badge.svg)](https://codecov.io/gh/ScottPierce/kotlin-html)
-->

# Kotlin HTML

## JVM Usage
```Kotlin
repositories {
    jcenter()
}

dependencies {
    // JVM version of the HTML library
    implementation("dev.scottpierce.kotlin-html:kotlin-html-writer-jvm:0.5.7")
    
    // If you are using Ktor, you can use this as well
    implementation("dev.scottpierce.kotlin-html:kotlin-html-ktor:0.5.7")
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
            implementation("dev.scottpierce.kotlin-html:kotlin-html-writer:0.5.7")
        }    
    }
}
```

# Basic Sample
```Kotlin
fun main() {
    // Choose a HtmlOutput implementation. StringHtmlOutput is good for testing.
    val output: HtmlOutput = StringHtmlOutput(options = WriteOptions.readable)

    // Writes the main page to the HtmlOutput
    writer.mainPage()

    // Prints out the written page
    println(writer)
}

fun HtmlOutput.mainPage() {
    html(DocType.Html) {
        head {
            styleSheet {
                style("body") {
                    margin(0.px)
                    padding(0.px)
                    color = Color(100, 100, 100)
                }
                style(".class2") {
                    background = Color("#555555")
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
            margin(1.rem)
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

# Style Builder

While the kotlin html writer allows for working with CSS directly, the style builder artifacts offer a more convenient
way of dealing with style sheets and media queries. Style builder allows you to write to a single style sheet from anywhere
in your HTML document. This means you can keep your styles closer to your elements, and also makes it easier to only write
the styles if you are using them. It also offers a much more convenient syntax for interacting with media queries by
allowing you to embed media query styles within already defined styles, keeping everything in one place.

1. Import the style builder artifacts:
```Kotlin
dependencies {
    implementation("dev.scottpierce.kotlin-html:kotlin-html-style-builder:0.5.7")
}
```

Style Builders allow you name media queries. It's easy to make your own, but we provide some prebuild ones for the names
`phone`, `tablet`, and `desktop`. Import what you want to use.
```Kotlin
dependencies {
    implementation("dev.scottpierce.kotlin-html:kotlin-html-style-builder-phone:0.5.7")
    implementation("dev.scottpierce.kotlin-html:kotlin-html-style-builder-tablet:0.5.7")
    implementation("dev.scottpierce.kotlin-html:kotlin-html-style-builder-desktop:0.5.7")
}
```

2. Specify where in your `head` that you want your style builder inserted
```Kotlin
html {
    head {
        insertStyleBuilder {
            insertMedia(StyleBuilder.TABLET, "(min-width: 481px) and (max-width: 767px)")
            insertMedia(StyleBuilder.PHONE, "(min-width: 320px) and (max-width: 480px)")
        }
    }
    // ...
}
```

3. Build your style from anywhere in your HTML document:
```Kotlin
html {
    // ...
    body {

        style("#example") {
            backgroundColor(255, 255, 255)
            phone {
                backgroundColor(0, 0, 0)            
            }
            tablet {
                backgroundColor(55, 55, 55)
            }
        }

        div(id = "example") {
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
        * Add an [Element](https://github.com/ScottPierce/kotlin-html/blob/master/kotlin-html-generator/src/main/kotlin/dev/scottpierce/html/generate/model/GeneratedElement.kt)
        * Add a [Style Property](https://github.com/ScottPierce/kotlin-html/blob/master/kotlin-html-generator/src/main/kotlin/dev/scottpierce/html/generate/model/GeneratedStyleProperty.kt)
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

## Integration with Ktor
``` Kotlin
dependencies {
    implementation("dev.scottpierce.kotlin-html:kotlin-html-ktor:0.5.7")
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

[See the Benchmark Code](https://github.com/ScottPierce/kotlin-html/blob/master/benchmark/src/jvmMain/kotlin/dev/scottpierce/html/benchmark/ThreadedBenchmark.kt)<br>
[raw benchmark data](https://docs.google.com/spreadsheets/d/1Yx_RiqxU4Hm9MxfH71YqVj2fiklrUqYSDkiiFVbBKis/edit?usp=sharing)

Benchmark Device:
<pre>
JDK 12.0.1
2018 MacBook Pro 15"
2.9 GHz Intel Core i9
32 GB Memory
</pre>
