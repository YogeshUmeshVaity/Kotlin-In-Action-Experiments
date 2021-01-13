package starprojection.lowerbound

open class Pet {
    val cutenessIndex: String = "not specified"
}

class Cat : Pet()

class Dog : Pet()

class Producer<out T : Pet> {
    private val pets = listOf<T>()
    fun produce() : T = pets.last()
}

fun useProducer(star: Producer<*>) {
    // Even though we use * here, T is known to be a Pet because it's an upper bound at the
    // declaration site, so the producer produces Pet and its subtypes.
    val pet = star.produce()

    // Pet is guaranteed. Can use properties and functions of Pet.
    pet.cutenessIndex
}

class Producer1<out T> {
    private val items = listOf<T>()
    fun produce() : T = items.last()
}

fun useProducer1(star: Producer1<*>) {
    // Produces Any?
    val anyNullable = star.produce() // Not useful

    // object is of unknown type. Can't use properties and functions of unknown type.
//  anyNullable.cutenessIndex      // Error
}


class Consumer<in T> {
    private val items = mutableListOf<T>()
    fun consume(item: T) = items.add(item)
    fun size(): Int = items.size
}

/*
The lower bound is not supported in Kotlin. So, in the `Consumer` class below, we cannot have
something like `in Pet : T`(lower bound) like we have `out T : Pet`(upper bound) in the
`Producer` class above. As we know a consumer can consume T and it's subtypes. `Nothing` is
the subtype of all types in Kotlin, just like `Any?` is the supertype of all types. And since,
the T is unknown in the star projection, the only known subtype of T, is Nothing. This is why a
consumer can consume Nothing. Hence, saying Consumer<*> is the same thing as saying Consumer<in Nothing>.
 */
fun useConsumer(consumer: Consumer<*>) {
    // Error: Cannot consume anything because lower bound is not supported in Kotlin and T is unknown.
//  consumer.consume(Pet())
    val anyNullable: Any? = null
//  consumer.consume(anyNullable)

    // Can only use the type parameter independent functions and properties.
    consumer.size()
}

fun getBiggerOfTwo(list1: List<*>, list2: List<*>) : List<*> {
    return if (list1.size >= list2.size) list1 else list2
}

fun main() {
    val petProducer = Producer<Pet>()
    val catProducer = Producer<Cat>()
//  val anyProducer = Producer<String>()    // Error because Pet is the upper bound
    //useProducer(petProducer)
    //useProducer(catProducer)

    val petConsumer = Consumer<Pet>()
    val catConsumer = Consumer<Cat>()
    val anyConsumer = Consumer<String>()
    //useConsumer(petConsumer)
    //useConsumer(catConsumer)

    val list1 = listOf(Cat(), Dog(), Cat())
    val list2 = listOf(Dog(), Cat(), Dog())
    val list3 = listOf(Pet(), Pet())

    println(getBiggerOfTwo(list1, list2))
    println(getBiggerOfTwo(list1, list3))
}