[![CircleCI](https://circleci.com/gh/ScottPierce/kotlin-html/tree/master.svg?style=svg)](https://circleci.com/gh/ScottPierce/kotlin-html/tree/master)
[![codecov](https://codecov.io/gh/ScottPierce/kotlin-html/branch/master/graph/badge.svg)](https://codecov.io/gh/ScottPierce/kotlin-html)

# Why this library?
I was seeking a simple Kotlin templating DSL that I could use for a project, 
[https://www.arseldrivingschool.com](https://www.arseldrivingschool.com). I found 
[kotlinx.html](https://github.com/Kotlin/kotlinx.html), but upon initial use, I found that it's API was clunky, lacking 
in features that I needed (i.e. styles), and lacking in features that I wanted (i.e. immutability). I also found that 
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
* Multiplatform
* Integration with Ktor

## Missing Features
* Complete list of all HTML elements, and style attributes
    * You can easily add your own by looking at an existing element and using it as a template. I recommend using 
    [span](/html-builder/src/genMain/kotlin/dev/scottpierce/html/element/Span.kt) as a template
    * PRs are welcome. If you add an element, please make sure you add it via the generator module
        * Add an [Element](https://github.com/ScottPierce/kotlin-html/blob/master/html-builder-generator/src/main/kotlin/dev/scottpierce/html/generate/model/Element.kt)
        * Add a [Style Property](https://github.com/ScottPierce/kotlin-html/blob/master/html-builder-generator/src/main/kotlin/dev/scottpierce/html/generate/model/StyleProperty.kt)
    
## Pull Requests Welcome
* If I haven't added the HTML element or CSS Property you want, you can add it yourself via the generation module 
[here](/html-builder-generator/src/main/kotlin/dev/scottpierce/html/generate/Model.kt). If you don't feel like trying 
yourself, please create an issue.
* Please talk to me in an issue before you do any major changes / refactors

## Examples
```kotlin
val htmlWriter: HtmlWriter = StringBuilderHtmlWriter() 
htmlWriter.html {
    head("custom-attribute" by "attribute-value")
    body {
        div(id = "divId", classes = "class1 class2")
    }
}
```
