# Changelog

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