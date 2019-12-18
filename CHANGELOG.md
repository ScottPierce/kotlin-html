# Changelog

## 0.7.0
* `styleBuilder` is renamed to `insertStyleBuilder`.

## 0.6.0
* `HtmlWriter` has been trimmed down to just the write methods, and it's name has been changed to `HtmlOutput`.
`HtmlWriter`, is instead used for something else.
* Added the ability for `HtmlWriter`s to split into named sub-writers.
* Added a new artifact - Style Builder. Style Builder can be used to write to a single stylesheet in the `head` of your
document from anywhere in your document. It can also be used to write to various media queries with a much nicer syntax
than CSS provides.
* Contexts were all moved to the `dev.scottpierce.html.writer` package.
* `FileContext` was removed, and the `docType` was added as a parameter to the `html` functions.

## 0.5.0
* Complete overhaul fo the style system, with a switch from properties to functions for styles.
* Several css properties have had their type safety dramatically improved.

## 0.4.0
* `Context` renamed to `HtmlWriterContext`
* `link` and `script` moved to `BaseHtmlContext`

## 0.3.0
* Package changed from `dev.scottpierce.html` to `dev.scottpierce.html.writer`
* Remove style read API and turn it into a pure streaming API.
* Make all `Context`s, `inline class`es.
* Change `Dimension` from a readable object to an `inline class`.