import samconstructors.JavaCalculator
import samconstructors.JavaAdder
import samconstructors.KotlinCalculator

fun customAdd(a: Int, b: Int): Int {
    val sum = a + b
    return when {
        sum < 100 -> -1
        sum < 200 -> 0
        else -> sum
    }
}

fun main() {
    val javaCalculator = JavaCalculator()

    // Passing the anonymous object explicitly
    javaCalculator.setAdder(object : JavaAdder {
        override fun add(a: Int, b: Int): Int {
            return a + b
        }
    })
    println(javaCalculator.add(20, 11))

    // If you already have the method defined, pass using member reference
    javaCalculator.setAdder(::customAdd)
    println(javaCalculator.add(20, 150))

    // The above statements can be simplified to following
    // Automatic conversion of lambda to anonymous object, no SAM constructor needed
    javaCalculator.setAdder { a, b -> a + b }
    println(javaCalculator.add(20, 13))

    // So when to use SAM constructor?
    // In cases, the compiler cannot automatically convert lambdas to anonymous objects
    // See createOrder() comments for an example
    val adder = createAdder()
    javaCalculator.setAdder(adder)
    println(javaCalculator.add(20, 14))

    // Apart from returning the values, you use the SAM constructor to store instances of
    // java functional interfaces into variables
    val adderVariable = JavaAdder { a: Int, b: Int -> a + b }
    javaCalculator.setAdder(adderVariable)
    println(javaCalculator.add(20, 15))

    // If you rewrite the Calculator class in Kotlin, and use function type
    // to define the adder, you don't need SAM constructor, because, like values,
    // Kotlin functions can be passed and returned as arguments.
    val kotlinCalculator = KotlinCalculator()
    kotlinCalculator.adder = {a, b -> a + b}
    println(kotlinCalculator.add(20, 16))

    kotlinCalculator.adder = ::customAdd
    println(kotlinCalculator.add(20, 17))


}

// If you have a method that returns an instance of java functional interface,
// you cannot return a lambda directly, in this case, you need to wrap it into a SAM constructor
fun createAdder() : JavaAdder {
    return JavaAdder { a: Int, b: Int -> a + b }
}

/* Conclusion: SAM constructors are used to write concise code for java functional interfaces.
 *             They are not required when you are dealing with kotlin function types.
 */