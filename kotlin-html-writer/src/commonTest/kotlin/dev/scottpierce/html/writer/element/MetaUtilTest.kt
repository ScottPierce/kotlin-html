package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.util.write
import kotlin.test.Test

class MetaUtilTest {
    @Test
    fun description() {
        write {
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
        write {
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
        write {
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
        write {
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
