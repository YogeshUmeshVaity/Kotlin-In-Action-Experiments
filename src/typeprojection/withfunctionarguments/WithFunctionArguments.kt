package typeprojection.withfunctionarguments

open class Fruit {
    fun getColor() { }
}

open class CitrusFruit : Fruit()

open class Orange : CitrusFruit() {
    fun getVitaminC() { }
}

class BloodOrange : Orange()
class MandarinOrange : Orange()

class Apple : Fruit()

/*
Type Projection

ArrayList in Kotlin is an producer as well as consumer. This is because it's an invariant generic
class defined as ArrayList<T> ,not as ArrayList<out T>(producer) or ArrayList<in T>(consumer).
This means ArrayList class can have functions that accept T as a function parameter (consume) or
return T (produce).

But what if you want to use this already existing class safely just as a producer(`out T`) or
just as a consumer(`in T`)? Without worrying about the accidental use of the unwanted functionality?

The solution is type projection. We project the types by using variance modifiers `in` and `out`
at the use-site. *Use-site* simply means wherever we use the `ArrayList` class.

*/

/*
When you are using the ArrayList as a producer(out), the function can accept the subtypes of ArrayList<Orange>, that is,
ArrayList<MandarinOrange>, ArrayList<BloodOrange> since MandarinOrange and BloodOrange are subtypes of Orange. Because the
subtyping is preserved.

And then the producer produces Orange and it's subtypes. Here producer.get(1) can return MandarinOrange, BloodOrange
etc. but we don't care as long as we get an Orange. Because we are only interested in using the properties
and functions of Orange.

Compiler doesn't allow calling the add() function (consumer) because we don't know which type of
Orange it contains. You don't want to accidentally add BloodOrange, if this is an ArrayList<MandarinOrange>.
 */
fun useAsProducer(producer: ArrayList<out Orange>) {

    // Orange is guaranteed
    val fruit = producer.get(1)           // OK

    // Can use functions and properties of Orange.
    fruit.getVitaminC()                         // OK

    // Consumer functions not allowed
//  producer.add(BloodOrange())               // Error
}

/*
When you are using ArrayList as a consumer(in), the function can accept the super types of ArrayList<Orange>,
that is, ArrayList<Fruits> because now the subtyping is reversed. This means ArrayList<Fruit> is a
subtype of ArrayList<Orange> when Orange is a subtype of Fruit.

And then the consumer consumes Orange and it's subtypes. It doesn't matter whether its MandarinOrange or
BloodOrange as long as it's an Orange. Because the consumer is only interested in the properties and functions
of Orange.

The compiler does allow the call to get() function (producer) but it produces Any?. The compiler
flags an error when you use the Any? as an Orange.
 */
fun useAsConsumer(consumer: ArrayList<in Orange>) {

    // Produces Any?, no guarantee of Orange because this could
    // be a Crate<Fruit> with apples in it.
    val anyNullable = consumer.get(1)     // Not useful

    // Not safe to call functions of Orange on the produced items.
//  anyNullable.getVitaminC()                // Error

    // in Orange, so consumes Orange and its subtypes.
    consumer.add(MandarinOrange())       // OK
}

/*
When you are using ArrayList as a producer and consumer (don't specify in or out), the function can
accept only the exact type ArrayList<Orange>, no other subtypes like ArrayList<MandarinOrange>. Because
there is not subtyping allowed for invariants.

The invariant produces Orange as well as consumes Orange. No other types allowed.

 */
fun useAsProducerConsumer(producerConsumer: ArrayList<Orange>) {
    // Produces orange, no subtypes
    val orange = producerConsumer.get(1)    // OK

    // Orange is guaranteed
    orange.getVitaminC()                    // OK

    // Consumes orange, no subtypes
    producerConsumer.add(Orange())          // OK
}
