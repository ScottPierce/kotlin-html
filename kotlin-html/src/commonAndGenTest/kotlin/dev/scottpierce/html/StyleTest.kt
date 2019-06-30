package dev.scottpierce.html

import dev.scottpierce.html.util.assertEquals
import dev.scottpierce.html.util.writeStyle
import dev.scottpierce.html.write.WriteOptions
import kotlin.test.Test

class StyleTest {
    @Test
    fun basic() {
        writeStyle {
            properties["blah"] = "blah"
        } assertEquals {
            "blah: blah;"
        }
    }

    @Test
    fun basicMinified() {
        writeStyle(options = WriteOptions(minifyStyles = true)) {
            properties["blah"] = "blah"
        } assertEquals {
            "blah:blah;"
        }
    }
}