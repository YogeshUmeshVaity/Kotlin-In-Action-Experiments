package comparetoimplementation

data class Person(val firstName: String, val lastName: String) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        // This function from the Kotlin standard library is used to implement compareTo()
        // in Kotlin easily and concisely.
        return compareValuesBy(this, other, { it.lastName }, Person::firstName)
    }
}

fun main() {
    val sandy = Person("Sandy", "Xyz")
    val monty = Person("Monty", "Abc")
    println("Is Sandy Xyz > Monty Abc ? : ${sandy > monty}")
    println("Is Sandy Xyz < Monty Abc ? : ${sandy < monty}")

    val selector = { person: Person -> person.lastName }
    println("Value of selector: ${selector(sandy)}")
    println("Is Value of selector A Comparable? : ${selector(sandy) is Comparable<*>}")
}