package dev.scottpierce.html.generate.model

fun String.snakeCaseToCamelCase(): String {
    val sb = StringBuilder()

    var isFirst = true
    for (part in split("-")) {
        if (isFirst) {
            isFirst = false
            sb.append(part)
        } else {
            sb.append(part.capitalize())
        }
    }

    return sb.toString()
}
