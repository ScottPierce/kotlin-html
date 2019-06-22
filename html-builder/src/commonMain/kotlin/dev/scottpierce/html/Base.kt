package dev.scottpierce.html

/**
 * The lowest level interface that designates that it can output code
 */
interface Writable {
    fun write(writer: HtmlWriter)
}

/**
 * A HTML tag
 */
interface Tag : Writable {
    val attrs: Attributes
}

/**
 * A HTML tag that has children
 */
interface ParentTag : Tag {
    val children: MutableList<Writable>
}

interface Content
interface BodyContent : Content
interface HeadContent : Content
