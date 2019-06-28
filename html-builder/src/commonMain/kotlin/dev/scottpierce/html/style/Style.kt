//@file:Suppress("EXPERIMENTAL_FEATURE_WARNING")
//
//package dev.scottpierce.html.style
//
//import dev.scottpierce.html.ArrayMap
//import dev.scottpierce.html.by
//import dev.scottpierce.html.write.HtmlWriter
//import dev.scottpierce.html.write.Writable
//import dev.scottpierce.html.write.writeStyle
//import kotlin.Unit
//
//interface Style : Writable {
//    val size: Int
//
//    operator fun get(property: String): Any?
//    operator fun iterator(): Iterator<Map.Entry<String, Any?>>
//
//    operator fun plus(style: Style): Style {
//        val propertiesList = ArrayList<MutableMap.MutableEntry<String, Any?>>(size + style.size)
//
//        for (prop in this) {
//            propertiesList += prop.key by prop.value
//        }
//
//        for (prop in style) {
//            propertiesList += prop.key by prop.value
//        }
//
//        return StyleBuilder(ArrayMap(propertiesList))
//    }
//}
//
//class StyleBuilder(
//    internal val properties: MutableMap<String, Any?> = ArrayMap(16)
//) : Style {
//    override val size: Int
//        get() = properties.size
//
//    override fun get(property: String): Any? = properties[property]
//
//    override fun iterator(): Iterator<Map.Entry<String, Any?>> = properties.iterator()
//
//    operator fun set(property: String, value: Any?) {
//        properties[property] = value
//    }
//
//    override operator fun plus(style: Style): StyleBuilder {
//        val properties = LinkedHashMap(properties).apply {
////            putAll(style.properties)
//        }
//        return StyleBuilder(properties)
//    }
//
//    operator fun Style.unaryPlus() {
//    }
//
//    operator fun StyleBuilder.unaryPlus() {
//        properties.putAll(this.properties)
//    }
//
//    override fun write(writer: HtmlWriter) {
//        writer.writeStyle(this)
//    }
//}
//
//inline fun style(func: StyleBuilder.() -> Unit): Style {
//    return StyleBuilder().apply(func)
//}
