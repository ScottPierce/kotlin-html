package dev.scottpierce.html.benchmark

import dev.scottpierce.html.writer.StringBuilderHtmlWriter
import dev.scottpierce.html.writer.WriteOptions
import dev.scottpierce.html.writer.element.a
import dev.scottpierce.html.writer.element.body
import dev.scottpierce.html.writer.element.button
import dev.scottpierce.html.writer.element.div
import dev.scottpierce.html.writer.element.h1
import dev.scottpierce.html.writer.element.h3
import dev.scottpierce.html.writer.element.head
import dev.scottpierce.html.writer.element.html
import dev.scottpierce.html.writer.element.metaCharsetUtf8
import dev.scottpierce.html.writer.element.metaDescription
import dev.scottpierce.html.writer.element.metaTitle
import dev.scottpierce.html.writer.element.metaViewport
import dev.scottpierce.html.writer.element.section
import dev.scottpierce.html.writer.element.span
import dev.scottpierce.html.writer.element.title
import dev.scottpierce.html.writer.style.backgroundColor
import dev.scottpierce.html.writer.style.styleSheet

fun kotlinHtmlPage(): String {
    val writer = StringBuilderHtmlWriter(options = WriteOptions.minified).apply {
        html {
            head {
                metaCharsetUtf8()
                metaViewport("width=device-width, initial-scale=1, shrink-to-fit=no")

                val title = "Driver Improvement Course - ARSEL Driving School"
                title(title)
                metaTitle(title)

                metaDescription("8 Hour Driver Improvement Course with ARSEL Driving School in Gainesville VA, Haymarket VA, Manassas VA, Centreville VA, Fairfax VA, Warrenton VA, Bristow VA")

                styleSheet {
                    ".style1" {
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                    }
                    ".style2" {
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                    }
                    ".style3" {
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                    }
                    ".style4" {
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                    }
                    ".style5" {
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                    }
                    ".style6" {
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                    }
                    ".style7" {
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                    }
                    ".style8" {
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                    }
                    ".style9" {
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                    }
                    ".style1" {
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                    }
                    ".style2" {
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                    }
                    ".style3" {
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                    }
                    ".style4" {
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                    }
                    ".style5" {
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                    }
                    ".style6" {
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                    }
                    ".style7" {
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                    }
                    ".style8" {
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                    }
                    ".style9" {
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                        backgroundColor(100, 100, 100)
                    }
                }
            }

            body {
                section(id = "header") {
                    div(id = "header-content") {
                        h1(id = "header-title") {
                            +"Driver Improvement Course"
                        }

                        h3(id = "header-description") {
                            +"An 8 hour driver improvement course"
                        }

                        div(id = "header-enroll-container") {
                            button(id = "header-enroll-button") {
                                +"Enroll Today"
                            }
                        }

                        div(id = "header-call-container") {
                            a(id = "header-call-button", classes = "center-vertical") {
                                span { +"Phone Number" }
                            }
                        }
                    }
                }

                // 18 divs deep
                section {
                    div {
                        div {
                            div {
                                div {
                                    div {
                                        div {
                                            div {
                                                div {
                                                    div {
                                                        div {
                                                            div {
                                                                div {
                                                                    div {
                                                                        div {
                                                                            div {
                                                                                div {
                                                                                    div {
                                                                                        div { +"Deep Div Test" }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                section {
                    repeat(100) {
                        div {
                            span {
                                div {
                                    span {
                                        +"Large block test"
                                        +it.toString()
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    return writer.toString()
}
