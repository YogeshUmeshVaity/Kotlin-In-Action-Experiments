package reifiedtypeparameters1

import kotlin.reflect.KType
import kotlin.reflect.typeOf

class Orange

/**
 * The KType includes KClass, type argument information and nullability information. Once you know
 * KType, you can perform reflection on it.
 */
@OptIn(kotlin.ExperimentalStdlibApi::class)
inline fun <reified T> getGenericType() {
    val type: KType = typeOf<T>()
    println(type)
}

fun main() {
    getGenericType<List<String>>()    // prints kotlin.collections.List<kotlin.String>
}