package reifiedtypeparameters

import kotlin.reflect.KClass
import kotlin.reflect.full.cast
import kotlin.reflect.typeOf

//fun <T> List<Any>.filterFruit1(): List<T> {
//    return this.filter { it is T }.map { it as T }
//}

fun <T: Any> List<Any>.filterFruit2(type: KClass<T>): List<T> {
    return this.filter { it::class == type }.map { type.cast(it)  }
}

/**
 * Kotlin's reified type parameters offer a more elegant solution to this problem.
 */
inline fun <reified T> List<Any>.filterFruit(): List<T> {
    return this.filter { it is T }.map { it as T }
}

fun main() {
    val fruits = listOf(Apple(), Orange(), Banana(), Orange())

    val oranges1 = fruits.filterFruit2(Orange::class)
    println(oranges1)

    val oranges2 = fruits.filterFruit<Orange>()
    println(oranges2)

    val oranges3 = fruits.filterIsInstance<Orange>()
    println(oranges3)
}