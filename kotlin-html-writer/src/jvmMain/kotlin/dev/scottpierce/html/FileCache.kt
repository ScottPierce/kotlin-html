package dev.scottpierce.html

import java.io.File
import java.io.FileNotFoundException
import java.util.LinkedHashMap
import java.util.concurrent.ConcurrentHashMap

object FileCache {
    var devMode = false

    private val cache = ConcurrentHashMap<File, List<String>>(100)

    fun get(file: File): List<String> {
        var fileText = if (devMode) null else synchronized(cache) { cache[file] }

        if (fileText == null) {
            try {
                fileText = file.bufferedReader().readLines()
                cache[file] = fileText
            } catch (e: FileNotFoundException) {
                throw FileNotFoundException(
                    e.message?.replace(file.toString(), file.absolutePath)
                        ?: "File Not found: ${file.absolutePath}"
                )
            }
        }

        return fileText
    }
}

class LruCache<K, V>(
    private val maxSize: Int
) : LinkedHashMap<K, V>(maxSize, 0.75f, true) {
    override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>?): Boolean {
        return size > maxSize
    }
}
