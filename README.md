# Why this library?
I was seeking a simple Kotlin server templating DSL that I could use for a project, 
[https://www.arseldrivingschool.com](https://www.arseldrivingschool.com). I found 
[kotlinx.html](https://github.com/Kotlin/kotlinx.html), but upon initial use, I found that it's API was clunky, lacking 
in features that I needed (i.e. styles), and lacking in features that I wanted (i.e. immutability). I also found that 
other users identified [similar issues](https://github.com/Kotlin/kotlinx.html/issues/31), and that no progress had 
been made for several years.

## Features
* HTML DSL
    * Explicit support for common html attributes for a cleaner api (i.e. id, classes, and attr)
* Style DSL
    * Inlining style to header or individual element
    * CSS
* Functionally Immutable
* Multiplatform
* Support for Ktor

## Missing Features
* Complete list of all HTML elements
    * You can easily add your own by looking at an existing tag and using it as a template. I recommend using 
    [span](/html-builder/src/genMain/kotlin/dev/scottpierce/html/element/Span.kt) as an example.
    * PRs are welcome. If you add an element, please make sure you add it via the [generator module](https://github.com/ScottPierce/kotlin-html-builder/blob/master/html-builder-generator/src/main/kotlin/dev/scottpierce/html/generate/Element.kt).
    
## Pull Requests Welcome
* If I haven't built out proper element generation for the `ElementType` you want, and don't feel like trying yourself, 
create an issue.
* Please talk to me in an issue before you do any major changes / refactors
