/*
*  @author: Ademir Queiroga <admqueiroga@gmail.com>
*  @created: 27/03/21
*/

import com.google.devtools.ksp.symbol.KSAnnotation
import com.google.devtools.ksp.symbol.KSClassDeclaration

@Suppress("NOTHING_TO_INLINE")
inline fun String.escaped() = "\"$this\""

fun KSAnnotation.findArgument(argName: String) = arguments.firstOrNull {
    it.name?.asString() == argName
}

inline fun <reified T> KSClassDeclaration.findAnnotation(): KSAnnotation? = annotations.find { annotation ->
    val qualifiedName = annotation.annotationType.resolve().declaration.qualifiedName?.asString()
    qualifiedName == T::class.qualifiedName
}