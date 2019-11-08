package dev.scottpierce.html.writer.style

internal fun writeBackgroundImages(urls: Array<out String>): String {
    val sb = StringBuilder()

    urls.forEachIndexed { i, url ->
        val isFirst = i == 0

        if (!isFirst) {
            sb.append(", ")
        }

        sb.append("url('").append(url).append("')")
    }

    return sb.toString()
}

internal fun writeBoxShadows(boxShadows: Array<out BoxShadow>): String = boxShadows.joinToString()
