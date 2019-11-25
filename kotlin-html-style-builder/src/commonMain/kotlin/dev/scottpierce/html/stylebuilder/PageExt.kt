package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.Page

private const val KEY_STYLESHEET = "page-stylesheet"

/**
 * Returns true if the global [StyleSheetBuilder] for the [Page] has been created yet.
 */
val Page.isStyleSheetCreated: Boolean
    get() = state.contains(KEY_STYLESHEET)

/**
 * Retrieves the global [StyleSheetBuilder] for the [Page]. If it doesn't exist, it will be created automatically.
 */
val Page.styleSheet: StyleSheetBuilder
    get() = state.getOrPut(KEY_STYLESHEET) { StyleSheetBuilder() } as StyleSheetBuilder
