package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.util.writeHtml
import kotlin.test.Test

class MetaUtilTest {
    @Test
    fun description() {
        writeHtml {
            head {
                metaDescription("test")
            }
        } assertEquals {
            """
            <head>
                <meta name="description" content="test">
            </head>
            """.trimIndent()
        }
    }

    @Test
    fun title() {
        writeHtml {
            head {
                metaTitle("test")
            }
        } assertEquals {
            """
            <head>
                <meta name="title" content="test">
            </head>
            """.trimIndent()
        }
    }

    @Test
    fun charset() {
        writeHtml {
            head {
                metaCharset("utf-8")
            }
        } assertEquals {
            """
            <head>
                <meta charset="utf-8">
            </head>
            """.trimIndent()
        }
    }

    @Test
    fun charsetUtf8() {
        writeHtml {
            head {
                metaCharsetUtf8()
            }
        } assertEquals {
            """
            <head>
                <meta charset="utf-8">
            </head>
            """.trimIndent()
        }
    }
}
