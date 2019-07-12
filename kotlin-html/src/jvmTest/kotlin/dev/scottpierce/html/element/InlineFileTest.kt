package dev.scottpierce.html.element

import org.junit.Test
import java.io.File

class InlineFileTest {
    @Test
    fun basic() {
        createWriter().apply {
            html {
                head {
                    script {
                        inlineFile(File("../test-files/example.js"))
                    }
                }
            }
        } assertEquals {
            """
            <html>
                <head>
                    <script>
                        function myFunction(p1, p2) {
                            return p1 * p2;   // The function returns the product of p1 and p2
                        }
                    </script>
                </head>
            </html>
            """.trimIndent()
        }
    }
}