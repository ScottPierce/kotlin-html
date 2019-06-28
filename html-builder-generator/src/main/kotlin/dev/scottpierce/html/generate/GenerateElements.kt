package dev.scottpierce.html.generate

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.UNIT
import java.io.File
import java.lang.RuntimeException


//val writeElement = MemberName("dev.scottpierce.html.write", "writeElement")
//val writeVoidElement = MemberName("dev.scottpierce.html.write", "writeVoidElement")
//
//fun generateTags(srcFolder: File) {
//    for (element in Element.values()) {
//        val elementName = element.tagName.capitalize()
//        val elementClassName = ClassName(filePackage, elementName)
//        val elementBuilderName = "${elementName}Builder"
//        val elementBuilderClassName = ClassName(filePackage, elementBuilderName)
//
//        val file = FileSpec.builder(filePackage, elementName)
//            .indent("    ")
//
//        file.addAnnotation(
//            AnnotationSpec.builder(Suppress::class)
//                .addMember("\"unused\"")
//                .build()
//        )
//
//        file.addComment("This file was generated using the `html-builder-generator` module. Instead of modifying it, " +
//                "modify the\n`html-builder-generator` and run it again.")
//
//        val isParent: Boolean = element.type !is ElementType.Void
//
//        // Generate functionally immutable interface
//        val elementType = TypeSpec.interfaceBuilder(elementClassName).apply {
//            addAnnotation(HtmlTag)
//
//            if (isParent) {
//                addSuperinterface(ContentElement)
//            } else {
//                addSuperinterface(TElement)
//            }
//
//            when (element.contentType) {
//                ContentType.HEAD -> addSuperinterface(HeadContent)
//                ContentType.BODY -> addSuperinterface(BodyContent)
//            }
//        }.build()
//
//        // Generate mutable builder class
//        val elementBuilderType = TypeSpec.classBuilder(elementBuilderClassName).apply {
//            addSuperinterface(elementClassName)
//
//            if (isParent) {
//                addSuperinterface(MutableContentElement)
//            } else {
//                addSuperinterface(TMutableElement)
//            }
//
//            primaryConstructor(
//                FunSpec.constructorBuilder()
//                    .addParameter("attrs", MutableAttributes)
//                    .build()
//            )
//
//            addProperty(
//                PropertySpec.builder("attrs", MutableAttributes, KModifier.OVERRIDE)
//                    .initializer("attrs")
//                    .build()
//            )
//
//            if (isParent) {
//                addProperty(
//                    PropertySpec.builder("children", WritableMutableList, KModifier.OVERRIDE)
//                        .initializer("%T(${element.childrenListInitialCapacity})", ArrayList)
//                        .build()
//                )
//            }
//
//            addFunction(
//                FunSpec.builder("write")
//                    .addModifiers(KModifier.OVERRIDE)
//                    .addParameter("writer", HtmlWriter)
//                    .apply {
//                        when (element.type) {
//                            is ElementType.Normal -> addCode("writer.%M(\"${element.tagName}\", this)\n", writeElement)
//                            is ElementType.Void -> addCode("writer.%M(\"${element.tagName}\", this)\n", writeVoidElement)
//                            else -> throw RuntimeException("Unsupported Tag Type")
//                        }
//                    }
//                    .build()
//            )
//        }.build()
//
//        file.addType(elementType)
//        file.addType(elementBuilderType)
//
//        fun createDslFunction(type: DslFunction): FunSpec {
//            val contentType: ClassName = when (element.contentType) {
//                ContentType.HEAD -> HeadContent
//                ContentType.BODY -> BodyContent
//            }
//
//            return FunSpec.builder(element.tagName)
//                .addTypeVariable(
//                    TypeVariableName.invoke(
//                        name = "T",
//                        bounds = *arrayOf(MutableContentElement)
//                    )
//                )
//                .receiver(TypeVariableName.invoke("T"))
//                .apply {
//                    val isParent = element.type !is ElementType.Void
//
//                    // No reason to inline if there is no lambda
//                    if (isParent) {
//                        addModifiers(KModifier.INLINE)
//                    }
//
//                    if (type == DslFunction.ATTR_VARARG) {
//                        addParameter(
//                            ParameterSpec.builder(
//                                "attrs",
//                                Attribute,
//                                KModifier.VARARG
//                            ).build()
//                        )
//                    } else if (type == DslFunction.ATTR_LIST) {
//                        addParameter(
//                            ParameterSpec.builder(
//                                "attrs",
//                                AttributeList
//                            ).build()
//                        )
//                    }
//
//                    for (attr in element.supportedAttributes) {
//                        addParameter(
//                            ParameterSpec.builder(attr, STRING.copy(nullable = true))
//                                .defaultValue("null")
//                                .build()
//                        )
//                    }
//
//                    if (isParent) {
//                        addParameter(
//                            ParameterSpec.builder("func", LambdaTypeName.get(receiver = elementBuilderClassName, returnType = TUnit))
//                                .defaultValue("{}")
//                                .build()
//                        )
//                    }
//
//                    when (type) {
//                        DslFunction.NO_ATTR -> {
//                            addCode("return addChild(id, classes, style${if (isParent) ", func" else ""}) { %T(it) }", elementBuilderClassName)
//                        }
//                        DslFunction.ATTR_LIST -> {
//                            addCode("return addChild(attrs, id, classes, style${if (isParent) ", func" else ""}) { %T(it) }", elementBuilderClassName)
//                        }
//                        DslFunction.ATTR_VARARG -> {
//                            addCode("return addChild(attrs, id, classes, style${if (isParent) ", func" else ""}) { %T(it) }", elementBuilderClassName)
//                        }
//                    }
//
//                    addCode("\n")
//                }
//                .returns(elementClassName)
//                .build()
//        }
//
//        // Generate DSL function
//        file.addFunction(createDslFunction(DslFunction.NO_ATTR))
//        file.addFunction(createDslFunction(DslFunction.ATTR_VARARG))
//        file.addFunction(createDslFunction(DslFunction.ATTR_LIST))
//
//        file.build()
//            .writeTo(srcFolder)
//    }
//}
//
//private enum class DslFunction {
//    NO_ATTR, ATTR_VARARG, ATTR_LIST
//}

fun generateElements(srcFolder: File): Unit = Element.values.forEach { element ->
    val elementName = element.tagName.capitalize()

    val file = FileSpec.builder(Constants.ELEMENT_PACKAGE, elementName)
        .indent("    ")
        .addComment(Constants.GENERATED_FILE_COMMENT)

    for (i in 0..1) {
        val isWriter = (i % 2) == 0

        for (type in DslFunction.values()) {
            file.addFunction(createDslFunction(element, isWriter, type))
        }
    }

    file.build()
        .writeTo(srcFolder)
}

fun createDslFunction(
    element: Element,
    isWriter: Boolean,
    functionType: DslFunction
): FunSpec = FunSpec.builder(element.tagName).apply {
    val childrenContext: Context? = element.childrenContext()
    val isParent = childrenContext != null

    val indent: String
    val deindent: String
    val writer: String
    if (isWriter) {
        indent = "indent"
        deindent = "deindent"
        writer = "this"
    } else {
        indent = "writer.indent"
        deindent = "writer.deindent"
        writer = "writer"
    }

    if (isWriter) {
        receiver(HTML_WRITER)
    } else {
        receiver(element.callingContext.contextClassName)
    }

    // No reason to inline if there is no lambda
    if (isParent) {
        addModifiers(KModifier.INLINE)
    }

    if (functionType == DslFunction.ATTR_VARARG) {
        addParameter(
            ParameterSpec.builder(
                "attrs",
                ATTRIBUTE,
                KModifier.VARARG
            ).build()
        )
    } else if (functionType == DslFunction.ATTR_LIST) {
        addParameter(
            ParameterSpec.builder(
                "attrs",
                ATTRIBUTE_LIST
            ).build()
        )
    }

    for (attr in element.supportedAttributes) {
        addParameter(
            ParameterSpec.builder(attr, STRING.copy(nullable = true))
                .defaultValue("null")
                .build()
        )
    }

    when (element) {
        is Element.Normal -> {
            addParameter(
                ParameterSpec.builder("func", LambdaTypeName.get(receiver = element.childrenContext.contextClassName, returnType = UNIT))
                    .defaultValue("{}")
                    .build()
            )
        }

        is Element.Void -> {
            // Do Nothing
        }
    }

//    if (!isWriter) {
//        // Writers are the entry point DSL functions. We don't need new lines at the very beginning
//        addStatement("$writer.newLine()")
//    }

    when (element) {
        is Element.Normal -> {
            if (functionType == DslFunction.NO_ATTR) {
                addStatement("$writer.%M(\"${element.tagName}\", id, classes, style)", WRITE_NORMAL_ELEMENT_START)
            } else {
                addStatement("$writer.%M(\"${element.tagName}\", id, classes, style, attrs)", WRITE_NORMAL_ELEMENT_START)
            }

            if (isParent) {
                when {
                    isWriter -> addStatement("%T($writer).apply(func)", childrenContext!!.contextClassName)
                    childrenContext == element.callingContext -> addStatement("func()")
                    else -> addStatement("%T($writer).apply(func)", childrenContext!!.contextClassName)
                }
            }

            addStatement("$writer.%M(\"${element.tagName}\")", WRITE_NORMAL_ELEMENT_END)
        }

        is Element.Void -> {
            if (functionType == DslFunction.NO_ATTR) {
                addStatement("$writer.%M(\"${element.tagName}\", id, classes, style)", WRITE_VOID_ELEMENT)
            } else {
                addStatement("$writer.%M(\"${element.tagName}\", id, classes, style, attrs)", WRITE_VOID_ELEMENT)
            }
        }
    }
}.build()

enum class DslFunction {
    NO_ATTR,
    ATTR_VARARG,
    ATTR_LIST,
    ;
}

fun Element.childrenContext(): Context? = when (this) {
    is Element.Normal -> childrenContext
    is Element.Void -> null
}