package starprojection.starvsotherprojections
// By projecting a type as out, in or *, we are telling the compiler that we intend to use an invariant
// class as an out, in or * respectively. So that if we accidentally use, say out (which is a producer)
// as a consumer then the compiler will help us by flagging an error at compile-time. This is what
// using a type in a safe way means.
// Projections also make the intent of the programmer clearer and make the code more readable.
// Just by looking at the function's parameter type ( for example, Crate<in Orange> type in
// useConsumer function), you or other programmer gets to know how you
// are using that parameter and what you are doing inside the function.
// Projections also enable you to use already existing invariant types the way you want. Be it
// as a producer, a consumer or as a star. This is also helpful for Java types where declaration
// site variance is not possible and all generic types are invariant.

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
 * We are telling the compiler that we intend to use the Crate as a contravariant. So, if by mistake,
 * if we try to use the Crate as contravariant, the it will help us by flagging an error.
 *
 * By using the out projection you are also turning an invariant class into a covariant.
 * The invariant class can only accept one type and not its subtypes. For example, the Crate<Fruit>
 * will only work with Fruit and not its subtypes but the Crate<out Fruit> will work with the Fruit
 * as well as its subtypes. This is another advantage of the type projection, apart from making the
 * the intent clear.
 *
 * Since this function accepts an out projection(covariant), this means that this function can be
 * passed the invariants Crate<Apple>, Crate<Orange> etc. This is because Crate<Apple>, Crate<Orange>
 * are subtypes of Crate<out Fruit>. The subtyping is preserved.
 *
 * And the Crate<out Fruit> will produce Fruit and its subtypes, that is, Apple, Orange etc.
 *
 */
fun useAsProducer(producer: Crate<out Fruit>) {
    // T is known to be a Fruit, so the producer produces Fruit objects.
    // This means a producer can produce a subtype (of Fruit in this case).
    val fruit = producer.produce()

    // Fruit is guaranteed, so its safe to access the properties and functions of Fruit.
    fruit.getColor()

    /* Error: We just know that it is a crate of Fruit but don't know exactly which Fruit. It can be
       a Crate<Orange>, a Crate<Apple> etc. This means we cannot add any Fruits to it.
       So the producer cannot consume the values because then you might add oranges to the crate of apples.
       And the next consumer that uses your crate might be surprised with oranges from a crate of apples.
       (They might get ClassCastException because they would have used an Apple as an Orange.)
       So, the compiler disallows adding to a producer.
       As we can see in the main function, a Crate<Apple> is passed to this function.
     */
//  producer.consume(Orange())
}

/**
 * Now this function represents a fruit producer.
 * val fruitProducer = returnAProducer()
 */
fun returnAProducer() : Crate<out Fruit> {
    return Crate<Orange>()
}

/**
 * We are telling the compiler that we intend to use the Crate as a contravariant. So, if by mistake,
 * we try to use the Crate as covariant, it will help us by flagging an error.
 *
 * Since this function accepts in projection(contravariant), this means that this function can be
 * passed the invariants Crate<Fruit> or other super types. This is because the Crate<Fruit> is a
 * subtype of Crate<in Orange>. The subtyping is reversed  because Orange is a subtype of Fruit.
 *
 * And the Crate<in Orange> will consume Orange and its subtypes, that is BloodOrange, MandarinOrange etc.
 */
fun useAsConsumer(consumer: Crate<in Orange>) {
    // Here the crate is used as a consumer and it is interested in oranges. It doesn't matter
    // whether it is a BloodOrange or a MandarinOrange or any other Orange, as long as it is a
    // subtype of the Orange.
    // This means the consumer can consume T or its subtype (of Orange in this case).
    consumer.consume(BloodOrange())
    consumer.consume(MandarinOrange())

    // There is no guarantee that the consumer will produce an Orange here. Because, someone else
    // might have used this same crate for storing apples before passing this crate to this function
    // as we have shown in main() function. So, if the consumer of Orange is not guaranteed to produce
    // an Orange, then why don't we get error when we call the produce() function on a consumer? Isn't
    // it unsafe? As it turns out, the language designers have decided to allow the consumer to produce
    // values but values of type Any?, not Orange( which is T) to keep it less restrictive. The safety
    // is achieved through the compiler error when we try to use that Any? type as an Orange as shown in
    // the next line.

    val anyNullable = consumer.produce()

    // Not safe to call functions of Orange because a consumer produces Any?, not Orange.
//  anyNullable.getVitaminC()

    // Even casting to Orange is unsafe because we saw how an Apple can sneak in.
    (anyNullable as Orange).getVitaminC()

    println("Size: ${consumer.size()}")
}

/**
 * Duplicate of the consumer above but with in Fruit as a projection instead of in Orange.
 */
fun useConsumer1(consumer: Crate<in Fruit>) {
    // Here the crate is used as a consumer and it is interested in Fruits. It doesn't matter
    // whether it is an Apple or an Orange or any other Fruit.
    consumer.consume(Orange())
    consumer.consume(Apple())

    consumer.produce()
    println("Size: ${consumer.size()}")
}

/**
 * We are telling the compiler that we intend to use the Crate as a neither covariant nor
 * contravariant. We intend to use only the properties and functions that don't include the type
 * parameter.
 */
fun useAsStar(star: Crate<*>) {
    // T is unknown, so the star produces the default supertype in Kotlin: Any? objects
    val anyNullable = star.produce()

    // Error: Cannot access getColor() function because it's Any?, not a Fruit.
//  anyNullable.getColor()

    // Error: Cannot consume values, because you don't know the type that the star variable accepts.
//  star.consume(Fruit())

    // Can only use the function that doesn't take or return the type parameter.
    println("Size: ${star.size()}")
}

/*
In this case, you are not really projecting the type, you are providing a specific type argument Any?.
The same with Any.
 */
fun useAnyNullable(any: Crate<Any?>) {
    // Crate<Any> produces as well as consumes unlike Crate<*> which only produces.
    // This is because compiler knows the type is Any whereas with star, it doesn't know the type.
    val anyNullable = any.produce()
    any.consume(Fruit())
}

fun useAsAny(any: Crate<Any>) {
    // Crate<Any> produces as well as consumes unlike Crate<*> which only produces.
    // This is because compiler knows the type is Any whereas with star, it doesn't know the type.
    val anyNonNull = any.produce()
    any.consume(Fruit())
}

fun main() {
    val fruitCrate = Crate<Fruit>()
    fruitCrate.consume(Apple())

    // Here, we are able to call the function which accepts Crate<in Orange> with Crate<Fruit>
    // because the Crate<Fruit> is a subtype of Crate<Orange> due to contravariant (reverse subtyping)
    useAsConsumer(fruitCrate)

    // Now crate contains Apple(), BloodOrange(), MandarinOrange()
    // This is why the consumer in useConsumer() function can only produce Any? at use site,
    // even though it is taking the parameter of type Crate<in Orange>. There is no guarantee that
    // it will produce an Orange. As we have proved how an Apple can sneak in.
    println(fruitCrate)

    val appleCrate = Crate<Apple>()
    useAsProducer(appleCrate)

//    val fruitProducer = returnAProducer()
//    fruitProducer.produce()
//    fruitProducer.consume(Orange())
}