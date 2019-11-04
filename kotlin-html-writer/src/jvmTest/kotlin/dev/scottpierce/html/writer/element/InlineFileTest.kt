package dev.scottpierce.html.writer.element

import java.io.File
import org.junit.Test

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
