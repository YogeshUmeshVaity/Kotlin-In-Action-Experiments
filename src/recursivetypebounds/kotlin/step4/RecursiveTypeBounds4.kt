package recursivetypebounds.kotlin.step4

// Introducing recursive type bound
/**
 * Solution: So, we tell the compiler that our T is a subtype of Fruit. In other words, we specify
 * the upper bound T : Fruit<T>. This makes sure that only subtypes of Fruit are allowed as type arguments.
 * Now the compiler knows that the size property can be found in the subtype of Fruit class because
 * the Comparable<T> also receives our type(Fruit<T>) that contains the size property.
 *
 * This allows us to get rid of the repeated code of compareTo() method and also allows us to compare the fruits
 * of the same types, apples with apples and oranges with oranges.
 *
 * This is called recursive type bound because we pass the bound of the same type(Fruit<T>) as a type argument for the
 * type parameter of that type(Fruit<T>). The concept of recursion is similar to the recursive functions when call
 * the same function from that very function.
 *
 * A recursive type is one that includes a function that uses that type itself as a type for some argument or its
 * return value. In our example, compareTo(T other) is the function of the recursive type that takes the same
 * recursive type as an argument.
 *
 * One thing to note here is that Comparable is passed Fruit<T> e.g. Apple, Orange etc, so it will
 * be able to call the method on those types. The Fruit class will also be able call the method on
 * those classes.
 *
 * In generics, you call the method on T. This is the reason while instantiating or inheriting
 * you need to pass the more specific type in place of T. That means the methods will be called on
 * that class (Apple, Orange etc).
 */
interface Fruit<T : Fruit<T>> : Comparable<T> {
    val size: Int
    override operator fun compareTo(other: T): Int {
        return size.compareTo(other.size)
    }
}

/**
 * Cyclic inheritance error. If you try to make a type for Fruit<Fruit<Fruit<T>>>
 */
//interface Fruit<T : Fruit<T: Fruit<T>>> : Comparable<T> {
//    val size: Int
//    override operator fun compareTo(other: T): Int {
//        return size.compareTo(other.size)
//    }
//}

class Apple(override val size: Int) : Fruit<Apple>

class Orange(override val size: Int) : Fruit<Orange>

/**
 * Caveat: if a programmer by mistake extends an Apple from Fruit<Orange> then our pattern breaks.
 * Now suddenly we are able to compare apples and oranges, we no longer get an error.
 */
// class Apple(override val size: Int) : Fruit<Orange>

fun main() {
    val apple1 = Apple(1)
    val apple2 = Apple(2)
    println(apple1 > apple2)


    val orange1 = Orange(1)
    val orange2 = Orange(2)
    println(orange1 < orange2)

//  println(apple1 < orange1)   // Error: different types.
}