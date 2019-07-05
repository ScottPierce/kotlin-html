[![CircleCI](https://circleci.com/gh/ScottPierce/kotlin-html/tree/master.svg?style=svg)](https://circleci.com/gh/ScottPierce/kotlin-html/tree/master)
<!---
This entire library is inline functions, and Jacoco doesn't show inline functions code coverage correctly: https://github.com/jacoco/jacoco/issues/654
[![codecov](https://codecov.io/gh/ScottPierce/kotlin-html/branch/master/graph/badge.svg)](https://codecov.io/gh/ScottPierce/kotlin-html)
-->

# Why this library?
I was seeking a simple Kotlin templating DSL that I could use for a project, 
[https://www.arseldrivingschool.com](https://www.arseldrivingschool.com). I knew about 
[kotlinx.html](https://github.com/Kotlin/kotlinx.html), but upon initial use, I found that it's API was clunky, lacking 
in features that I needed (i.e. styles), and lacking in features that I wanted. I also found that 
other users identified [similar issues](https://github.com/Kotlin/kotlinx.html/issues/31), and that no progress had 
been made for several years.

## Features
* HTML DSL
    * Explicit support for common html attributes for a cleaner api (i.e. id, classes, and attr)
    * Lightweight streaming API
        * Doesn't create a lot of unnecessary objects to represent the DOM. i.e. DOM introspection isn't possible
* Style DSL
    * Allows inlining style to the header or individual elements
    * CSS
* Functionally Immutable
* Multi-platform
* Integration with [Ktor](https://ktor.io/)

## Missing Features
* Complete list of all HTML elements, and style attributes
    * You can easily add your own by looking at an existing element and using it as a template. I recommend using 
    [span](./kotlin-html/src/genMain/kotlin/dev/scottpierce/html/element/Span.kt) as a template for normal elements
    * PRs are welcome. If you add an element, please make sure you add it via the generator module
        * Add an [Element](https://github.com/ScottPierce/kotlin-html/blob/master/kotlin-html-generator/src/main/kotlin/dev/scottpierce/html/generate/model/Element.kt)
        * Add a [Style Property](https://github.com/ScottPierce/kotlin-html/blob/master/kotlin-html-generator/src/main/kotlin/dev/scottpierce/html/generate/model/StyleProperty.kt)
    
## Pull Requests Welcome
* If I haven't added the HTML element or CSS Property you want, you can add it yourself via the generation module 
yourself, please create an issue.
* Please talk to me in an issue before you do any major changes / refactors

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
                style(".class1") {
                    // TODO
                }
                style(".class2") {
                    // TODO
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
        style = style {
            // Inline style here
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
    span(style = style { /* Inline span style here */ }) {
        +"Footer Text"
    }
}
```

# Benchmark
![kotlin-html vs kotlinx.html benchmark](https://docs.google.com/spreadsheets/d/e/2PACX-1vSzaUiakNFkWywUTO63oSOg1uMoHrs62wju4oDyzeAcK7RsPfyuS4S7OsVp7sba007QVYf3GoE0nA9j/pubchart?oid=492427110&format=image)

\<Insert obligatory disclaimer about microbenchmarks here\>

**kotlin-html (this library) averaged 457 millis to create a page of ~7700 characters 100k times, and kotlinx.html averaged 1186 millis to create the 
same page page 100k times. That means that kotlin-html enjoys 2.6X performance improvement over kotlinx.html in this test case.**
 
The test was performed by creating the same html page in kotlin-html and kotlinx.html, and then running the page creation 100k 
times. Each test was run 50 times for warmup, and then 50 iterations to get an average. The reality is that both of the 
libraries are fast enough that performance doesn't really matter for a normal use-case.

[See the Benchmark Code](./benchmark/src/main/kotlin/dev/scottpierce/html/benchmark/HtmlBenchmark.kt)<br>
[raw benchmark data](https://docs.google.com/spreadsheets/d/1Yx_RiqxU4Hm9MxfH71YqVj2fiklrUqYSDkiiFVbBKis/edit?usp=sharing)

Benchmark Device:
<pre>
JDK 12.0.1
2018 MacBook Pro 15"
2.9 GHz Intel Core i9
32 GB Memory
</pre>
