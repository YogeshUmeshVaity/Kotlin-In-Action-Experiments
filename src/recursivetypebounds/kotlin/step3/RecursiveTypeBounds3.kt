package recursivetypebounds.kotlin.step3

// Introducing type parameter
/*
To restrict comparison of different types, we introduce a type parameter. So that the comparable Fruit<Apple>
cannot be compared to comparable Fruit<Orange>.

Problem: The size property of T is unknown to the compiler. This is because the type parameter T of our
Fruit class doesn't have any bound. So, the T could be any class, it is not possible that every class would
have a size property. So the compiler is right in not recognizing the size property of T.
 */

interface Fruit<T> : Comparable<T> {
    val size: Int
    override operator fun compareTo(other: T): Int {
//      return size.compareTo(other.size) // Error: size property not available.
        return 0    // we return 0 here so, our project stays without errors.
    }
}

class Apple(override val size: Int) : Fruit<Apple>

class Orange(override val size: Int) : Fruit<Orange>

fun main() {
    val apple1 = Apple(3)
    val apple2 = Apple(4)
    println(apple1 > apple2)


    val orange1 = Orange(3)
    val orange2 = Orange(4)
    println(orange1 < orange2)

//  println(apple1 < orange1)   // Error: different types.
}