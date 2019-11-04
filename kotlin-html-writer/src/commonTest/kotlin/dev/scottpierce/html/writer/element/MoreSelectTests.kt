package dev.scottpierce.html.writer.element

import kotlin.test.Test

class MoreSelectTests {
    @Test
    fun default() {
        createWriter().apply {
            select(classes = "selectClass") {
                option(id = "optionId", value = "testValue") {
                    span { +"Test" }
                }
            }
        } assertEquals {
            """
            <select class="selectClass">
                <option id="optionId" value="testValue">
                    <span>
                        Test
                    </span>
                </option>
            </select>
            """.trimIndent()
        }
    }
}
