package recursivetypebounds.kotlin.step2

// Moving the repeated code to a common class.
/**
 * Problem: Able to compare different types.
 *
 * Here, we move the repeated code to a common class. The repeated code problem solves but we have another
 * problem. We are not able to achieve our objective of restricting the comparison of different types. Here
 * we are able to compare apples with oranges which is not what we want.
 */
interface Fruit : Comparable<Fruit> {
    val size: Int
    override operator fun compareTo(other: Fruit): Int {
        return size.compareTo(other.size)
    }
}

class Apple(override val size: Int) : Fruit

class Orange(override val size: Int) : Fruit

fun main() {
    val apple1 = Apple(3)
    val apple2 = Apple(4)
    println(apple1 > apple2)


    val orange1 = Orange(3)
    val orange2 = Orange(4)
    println(orange1 < orange2)

    println(apple1 < orange1)   // No Error: we are able to compare different types.
}
