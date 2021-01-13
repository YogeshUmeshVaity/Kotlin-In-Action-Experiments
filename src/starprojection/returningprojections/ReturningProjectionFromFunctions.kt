package starprojection.returningprojections

open class Fruit {
    fun getColor() { }
}

open class Orange : Fruit() {
    fun getVitaminC() { }
}

class BloodOrange : Orange()
class MandarinOrange : Orange()

class Apple : Fruit()

/**
 * Invariant
 */
class Crate<T> {
    private val items = mutableListOf<T>()
    fun produce(): T = items.last()
    fun consume(item: T) = items.add(item)
    fun size(): Int = items.size
    override fun toString(): String = items.toString()
}

/**
 * Now this function represents a fruit producer.
 * val fruitProducer = returnAProducer()
 */
fun returnAProducer(): Crate<out Fruit> {
    return Crate<Orange>()
}

// Error: T is undefined
//fun returnAProducer1(): T {
//    return Crate<Orange>()
//}

// Error: Variance annotations only allowed classes and interfaces
//fun <out Crate<Fruit>> returnAProducer2(): T {
//    return Crate<Orange>()
//}

// Error: Type mismatch, required T, found Crate<Orange>
//fun <T : Crate<Fruit>> returnAProducer3(): T {
//    return Crate<Orange>()
//}

fun returnAProducer1(): Crate<*> {
    return Crate<Orange>()
}
