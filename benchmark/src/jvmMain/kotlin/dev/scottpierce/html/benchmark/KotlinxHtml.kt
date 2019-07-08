package dev.scottpierce.html.benchmark

import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.dom.document
import kotlinx.html.dom.serialize
import kotlinx.html.stream.appendHTML

fun kotlinxHtmlStream(): String {
    val sb = StringBuilder()

    sb.appendHTML(prettyPrint = false).html {
        head {
            meta(charset = "utf-8")
            meta(name = "viewport", content = "width=device-width, initial-scale=1, shrink-to-fit=no")

            val title = "Driver Improvement Course - ARSEL Driving School"
            title(title)
            meta(name = "title", content = title)
            meta(name = "description", content = "8 Hour Driver Improvement Course with ARSEL Driving School in Gainesville VA, Haymarket VA, Manassas VA, Centreville VA, Fairfax VA, Warrenton VA, Bristow VA")
        }

        body {
            section {
                id = "header"

                div {
                    id = "header-content"

                    h1 {
                        id = "header-title"

                        +"Driver Improvement Course"
                    }

                    h3 {
                        id = "header-description"

                        +"An 8 hour driver improvement course"
                    }

                    div {
                        id = "header-enroll-container"

                        button() {
                            id = "header-enroll-button"
                            +"Enroll Today"
                        }
                    }

                    div {
                        id = "header-call-container"

                        a(classes = "center-vertical") {
                            id = "header-call-button"

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

    return sb.toString()
}

fun kotlinxHtmlDom(): String {
    val document = document {
        append {
            html {
                head {
                    meta(charset = "utf-8")
                    meta(name = "viewport", content = "width=device-width, initial-scale=1, shrink-to-fit=no")

                    val title = "Driver Improvement Course - ARSEL Driving School"
                    title(title)
                    meta(name = "title", content = title)
                    meta(
                        name = "description",
                        content = "8 Hour Driver Improvement Course with ARSEL Driving School in Gainesville VA, Haymarket VA, Manassas VA, Centreville VA, Fairfax VA, Warrenton VA, Bristow VA"
                    )
                }

                body {
                    section {
                        id = "header"

                        div {
                            id = "header-content"

                            h1 {
                                id = "header-title"

                                +"Driver Improvement Course"
                            }

                            h3 {
                                id = "header-description"

                                +"An 8 hour driver improvement course"
                            }

                            div {
                                id = "header-enroll-container"

                                button() {
                                    id = "header-enroll-button"
                                    +"Enroll Today"
                                }
                            }

                            div {
                                id = "header-call-container"

                                a(classes = "center-vertical") {
                                    id = "header-call-button"

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
    }

    return document.serialize(false)
}
