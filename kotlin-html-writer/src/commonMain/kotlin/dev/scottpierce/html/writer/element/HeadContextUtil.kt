package dev.scottpierce.html.writer.element

@HtmlDsl
fun HeadContext.linkStyleSheet(href: String) {
    page.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"").write(href).write("\">")
}
