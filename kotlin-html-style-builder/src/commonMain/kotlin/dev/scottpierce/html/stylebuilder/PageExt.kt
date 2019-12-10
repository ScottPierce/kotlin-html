package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.HtmlWriter

private const val KEY_STYLESHEET = "page-stylesheet"

/**
 * Returns true if the global [StyleSheetBuilder] for the [HtmlWriter] has been created yet.
 */
val HtmlWriter.isStyleSheetCreated: Boolean
    get() = state.contains(KEY_STYLESHEET)

/**
 * Retrieves the global [StyleSheetBuilder] for the [HtmlWriter]. If it doesn't exist, it will be created automatically.
 */
val HtmlWriter.styleSheet: StyleSheetBuilder
    get() = state.getOrPut(KEY_STYLESHEET) { StyleSheetBuilder() } as StyleSheetBuilder
