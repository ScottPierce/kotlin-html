package dev.scottpierce.html.benchmark

import dev.scottpierce.html.element.*
import dev.scottpierce.html.write.StringBuilderHtmlWriter
import dev.scottpierce.html.write.WriteOptions

fun kotlinHtmlPage(): String {
    val writer = StringBuilderHtmlWriter(initialCapacity = 8000, options = WriteOptions.minified).apply {
        html {
            head {
                metaCharsetUtf8()
                metaViewport("width=device-width, initial-scale=1, shrink-to-fit=no")

                val title = "Driver Improvement Course - ARSEL Driving School"
                title(title)
                metaTitle(title)

                metaDescription("8 Hour Driver Improvement Course with ARSEL Driving School in Gainesville VA, Haymarket VA, Manassas VA, Centreville VA, Fairfax VA, Warrenton VA, Bristow VA")
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