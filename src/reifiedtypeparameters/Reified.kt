package reifiedtypeparameters

import kotlin.reflect.KClass

class Orange
class Apple
class Banana

//fun <T> filterFruits(fruitList: List<*>): List<T> {
//    val filteredFruits = mutableListOf<T>()
//    for (fruit in fruitList) {
//        if (fruit is T) {             // Error: Cannot check for instance of erased type: T
//            filteredFruits.add(fruit)
//        }
//    }
//    return filteredFruits
//}

fun <T : Any> filterFruits2(fruitList: List<Any>, type: Class<T>): List<T> {
    val filteredFruits = mutableListOf<T>()
    for (fruit in fruitList) {
        if (fruit.javaClass == type) {             // Error: Cannot check for instance of erased type: T
            filteredFruits.add(fruit as T)
        }
    }
    return filteredFruits
}

inline fun <reified T> filterFruits1(fruitList: List<*>): List<T> {
    val filteredFruits = mutableListOf<T>()
    for (fruit in fruitList) {
        if (fruit is T) {
            filteredFruits.add(fruit)
        }
    }
    return filteredFruits
}

fun main() {
    val fruits = listOf(Apple(), Orange(), Banana(), Orange())
    val oranges = filterFruits1<Orange>(fruits)
    println(oranges)
}