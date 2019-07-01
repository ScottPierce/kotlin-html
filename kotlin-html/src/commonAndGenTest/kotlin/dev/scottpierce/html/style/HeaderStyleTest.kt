package dev.scottpierce.html.style

import dev.scottpierce.html.element.head
import dev.scottpierce.html.element.html
import dev.scottpierce.html.util.writeFile
import kotlin.test.Test

class HeaderStyleTest {
    @Test
    fun headerStyle() {
        writeFile {
            html {
                head {
                    styleSheet {

                    }
                }
            }
        }
    }
}
