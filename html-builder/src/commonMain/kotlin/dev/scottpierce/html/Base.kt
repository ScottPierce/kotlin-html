package dev.scottpierce.html

/**
 * The lowest level interface that designates that it can output code
 */
interface Writable {
    fun write(writer: Writer)
}

/**
 * A HTML tag
 */
interface Tag : Writable {
    val attributes: MutableAttributes
}

/**
 * A HTML tag that has children
 */
interface ParentTag : Tag {
    val children: MutableList<Tag>
}

interface Content
interface BodyContent : Content
interface HeadContent : Content
