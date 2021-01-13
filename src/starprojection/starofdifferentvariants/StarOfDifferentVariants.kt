package starprojection.starofdifferentvariants

/**
 * There are multiple ways to combine use-site and declaration-site variance.
 */


open class Fruit {
    fun getColor() { }
}

open class CitrusFruit() : Fruit()

open class Orange : CitrusFruit() {
    fun getVitaminC() { }
}

class BloodOrange : Orange()
class MandarinOrange : Orange()

class Apple : Fruit()

/**
 * Covariant
 */
class ProducerCrate<out T : Fruit> {
    private val fruits = listOf<T>()

    fun produce() : T = fruits.last()
}

/**
 * Contravariant. Note that there is no lower bound in Kotlin, like 'in T super Orange'. So we can't
 * use T in this case. https://discuss.kotlinlang.org/t/generic-constraints-lower-bound/15074
 *
 * There is a mistake in this class. The Orange is used as a type parameter and not as type argument.
 * This means Orange is a fresh variable here and it should replaced with T.
 */
class ConsumerCrate1<in Orange> {
    private val fruits = mutableListOf<Orange>()

    fun consume(fruit: Orange) = fruits.add(fruit)
    fun size(): Int = fruits.size
}

class ConsumerCrate<in T> {
    private val items = mutableListOf<T>()
    fun consume(item: T) = items.add(item)
    fun size(): Int = items.size
}

/**
 * Important: The Fruit here is a type parameter, not the actual Fruit class that is defined above.
 * The Fruit in this class is called as a fresh variable in type theory. A fresh variable means
 * it is not already defined anywhere. We can remove the Fruit class defined above, and we still
 * won't get the error unresolved symbol for the Fruit parameter below.
 * To make it invariant on Fruit, we must use T : Fruit, not just Fruit.
 */
class ProducerConsumerCrate1<Fruit> {
    private val fruits = mutableListOf<Fruit>()

    fun produce(): Fruit = fruits.last()
    fun consume(fruit: Fruit) = fruits.add(fruit)
}

/**
 * What is the difference between out T : Fruit and T : Fruit? The first one is covariant and the
 * second one is invariant. As you can see the the compiler allows us to write the consumer function
 * for the invariant.
 */
class ProducerConsumerCrate<T : Fruit> {
    private val fruits = mutableListOf<T>()

    fun produce(): T = fruits.last()
    fun consume(fruit: T) = fruits.add(fruit)
}

fun useProducer(star: ProducerCrate<*>) {
    // Even though we use * here, T is known to be a Fruit because it's an upper bound at the
    // declaration site, so the producer produces Fruit objects.
    // This means a producer can produce a subtype of Fruit.
    val fruit = star.produce()

    // Fruit is guaranteed, so its safe to access the properties and functions of Fruit.
    fruit.getColor()

    // We don't have to worry about calling the consume() function because the compiler prevents it from
    // defining at the declaration site itself. As the consumer functions don't exist, there is no
    // question of calling them accidentally.
//  star.consume(Orange())

}

fun useConsumer(consumer: ConsumerCrate<*>) {
    // Error: Cannot consume anything because lower bound is not supported in Kotlin and T is unknown.
//  consumer.consume(Orange())
//  consumer.consume(MandarinOrange())


    // We don't have to worry about calling the produce() function because the compiler prevents it from
    // defining at the declaration site itself. As the producer functions don't exist, there is no
    // question of calling them accidentally.
//  val anyNullable = consumer.produce()

    // Can only use the type parameter independent functions and properties.
    consumer.size()
}

fun useProducerConsumer(producerConsumer: ProducerConsumerCrate<*>) {

    // Even though we use *, the upper bound of the invariant type is known to be Fruit.
    // Now look at the difference between the star projection of Crate<T> and the star projection
    // of Crate<T : Fruit>. The star projection of Crate<T> produces Any? and star projection of
    // Crate<T : Fruit> produces a Fruit.
    val fruit = producerConsumer.produce()

    // Fruit is guaranteed, so its safe to access the properties and functions of Fruit.
    fruit.getColor()

    // Error: When you define an upper bound on T (that is, T : Fruit), the star projection of that
    // generic type acts like a producer, so the consumer functions are not allowed to be called.
    // Consumer not allowed because you don't want to accidentally add oranges, if the crate turns
    // out to be of apples. This is shown in the main() function.
//  producerConsumer.consume(Fruit())

    // In this case, it might just be better to project ProducerConsumer<Fruit> instead of star. Need
    // to confirm this. Edit: No, we can't use Fruit instead of star because we need support other
    // subtypes of Fruit. If we say ProducerConsumer<Fruit> then it will be an invariant and the
    // subtypes of Fruit won't be supported.
}

fun main() {
    // Reason why consumer <in Orange> can't consume even an Orange.
    val fruitCrate = ConsumerCrate<Apple>()
    fruitCrate.consume(Apple())
    useConsumer(fruitCrate)

    val orangeCrate = ProducerConsumerCrate<Orange>()
    useProducerConsumer(orangeCrate)
}
