package dev.scottpierce.html.element

@HtmlDsl
fun HeadContext.linkStyleSheet(href: String) {
    writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"").write(href).write("\">")
}
