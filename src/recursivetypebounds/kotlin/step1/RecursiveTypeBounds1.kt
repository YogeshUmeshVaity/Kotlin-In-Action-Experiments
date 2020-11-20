package recursivetypebounds.kotlin.step1

/**
 * Problem: Repeated code
 *
 * Our use case is to be able to compare only the same types. We don't want to compare apples with oranges.
 * The code in this sample works. We are able to compare apples with other apples. When we try to compare
 * an apple with an orange we get an error as expected.
 *
 * But there is a problem: the code for implementing the compareTo method is duplicated in all the classes
 * that we extend from the Fruit. The amount of repeated code in our example is less but in real world use
 * cases the repeated code can be of thousands of lines.
 */
interface Fruit {
    val size: Int
}

class Apple(override val size: Int) : Fruit, Comparable<Apple> {

    override operator fun compareTo(other: Apple): Int {
        return size.compareTo(other.size)
    }
}

class Orange(override val size: Int) : Fruit, Comparable<Orange> {

    override operator fun compareTo(other: Orange): Int {
        return size.compareTo(other.size)
    }
}

fun main() {
    val apple1 = Apple(3)
    val apple2 = Apple(4)
    println(apple1 > apple2)


    val orange1 = Orange(3)
    val orange2 = Orange(4)
    println(orange1 < orange2)

//  println(apple1 < orange1)  // Error: different types
}
