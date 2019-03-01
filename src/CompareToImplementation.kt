package comparetoimplementation

data class Person(val firstName: String, val lastName: String) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::lastName, Person::firstName)
    }
}

fun main() {
    val sandy = Person("Sandy", "Xyz")
    val monty = Person("Monty", "Abc")
    println("Is Sandy Xyz > Monty Abc ? : ${sandy > monty}")
    println("Is Sandy Xyz < Monty Abc ? : ${sandy < monty}")
}