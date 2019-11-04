package dev.scottpierce.html.generate.model

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.LIST
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.STRING

val HTML_WRITER = ClassName("dev.scottpierce.html.write", "HtmlWriter")
val INLINE_STYLE = ClassName("dev.scottpierce.html.writer.style", "InlineStyle")
val BASE_STYLE_CONTEXT = ClassName("dev.scottpierce.html.writer.style", "BaseStyleContext")
val INLINE_STYLE_CONTEXT = ClassName("dev.scottpierce.html.writer.style", "InlineStyleContext")
val INLINE_STYLE_LAMBDA = ClassName("dev.scottpierce.html.writer.style", "InlineStyleLambda")
val ATTRIBUTE = ClassName("kotlin", "Pair").parameterizedBy(STRING, STRING.copy(nullable = true))
val ATTRIBUTE_LIST = LIST.parameterizedBy(ATTRIBUTE)
val TEST = ClassName("kotlin.test", "Test")
val HTML_DSL = ClassName("dev.scottpierce.html.writer.element", "HtmlDsl")
val UNSUPPORTED_OPERATION_EXCEPTION = ClassName("kotlin", "UnsupportedOperationException")

val WRITE_NORMAL_ELEMENT_START = MemberName("dev.scottpierce.html.writer.element", "writeNormalElementStart")
val WRITE_NORMAL_ELEMENT_END = MemberName("dev.scottpierce.html.writer.element", "writeNormalElementEnd")
val WRITE_VOID_ELEMENT = MemberName("dev.scottpierce.html.writer.element", "writeVoidElement")
val STYLE_MEMBER = MemberName("dev.scottpierce.html.writer.style", "style")
val ASSERT_EQUALS = MemberName("kotlin.test", "assertEquals")
