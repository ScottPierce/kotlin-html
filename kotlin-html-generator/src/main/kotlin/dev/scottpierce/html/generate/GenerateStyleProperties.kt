package dev.scottpierce.html.generate

import dev.scottpierce.html.generate.model.Constants
import dev.scottpierce.html.generate.model.StyleProperty
import java.io.File

fun generateStyleProperties() {
    File("${Constants.BASE_GEN_DIR}/dev/scottpierce/html/style/").deleteRecursively()

    for (property in StyleProperty.values()) {
        generateProperty(property)
    }
}

private fun generateProperty(property: StyleProperty) {

}