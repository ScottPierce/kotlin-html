package dev.scottpierce.html.generate.model

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.LIST
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.STRING

val HTML_WRITER = ClassName("dev.scottpierce.html.writer", "HtmlOutput")
val PAGE_WRITER = ClassName("dev.scottpierce.html.writer", "PageWriter")
val INLINE_STYLE = ClassName("dev.scottpierce.html.writer", "InlineStyle")
val BASE_HTML_CONTEXT = ClassName("dev.scottpierce.html.writer", "BaseHtmlContext")
val BASE_STYLE_CONTEXT = ClassName("dev.scottpierce.html.writer", "BaseStyleContext")
val STYLE_CONTEXT = ClassName("dev.scottpierce.html.writer", "StyleContext")
val INLINE_STYLE_CONTEXT = ClassName("dev.scottpierce.html.writer", "InlineStyleContext")
val INLINE_STYLE_LAMBDA = ClassName("dev.scottpierce.html.writer", "InlineStyleLambda")
val WRITE_OPTIONS = ClassName("dev.scottpierce.html.writer", "WriteOptions")
val ATTRIBUTE = ClassName("kotlin", "Pair").parameterizedBy(STRING, STRING.copy(nullable = true))
val ATTRIBUTE_LIST = LIST.parameterizedBy(ATTRIBUTE)
val TEST = ClassName("kotlin.test", "Test")
val HTML_DSL = ClassName("dev.scottpierce.html.writer", "HtmlDsl")
val UNSUPPORTED_OPERATION_EXCEPTION = ClassName("kotlin", "UnsupportedOperationException")
val DIMENSION = styleClassName("Dimension")
val CSS_VALUE = styleClassName("CssValue")
val FLEX_BASIS = ClassName(Constants.STYLE_PACKAGE, "FlexBasis")
val COLOR = ClassName(Constants.STYLE_PACKAGE, "Color")
val DURATION = ClassName("kotlin.time", "Duration")

val WRITE_NORMAL_ELEMENT_START = MemberName("dev.scottpierce.html.writer.element", "writeNormalElementStart")
val WRITE_NORMAL_ELEMENT_END = MemberName("dev.scottpierce.html.writer.element", "writeNormalElementEnd")
val WRITE_VOID_ELEMENT = MemberName("dev.scottpierce.html.writer.element", "writeVoidElement")
val STYLE_MEMBER = MemberName("dev.scottpierce.html.writer.style", "style")
val ASSERT_EQUALS = MemberName("kotlin.test", "assertEquals")
val WRITE_STYLE_PROPERTY = MemberName("dev.scottpierce.html.writer.style", "writeStyleProperty")
val TO_WRITER = MemberName("dev.scottpierce.html.writer", "writer")

fun styleClassName(simpleName: String): ClassName = ClassName(Constants.STYLE_PACKAGE, simpleName)
