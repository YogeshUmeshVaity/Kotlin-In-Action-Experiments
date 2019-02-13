package samconstructors

class KotlinCalculator {
    // Define 'function type' with default implementation
    // As the variables number1 and number2 are not used,
    // they are specified with underscore
    var adder: (Int, Int) -> Int = { _, _ -> 0 }

    fun add(number1: Int, number2: Int): Int {
        return adder(number1, number2)
    }
}