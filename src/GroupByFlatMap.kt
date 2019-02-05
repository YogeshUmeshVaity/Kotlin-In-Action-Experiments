import com.functional.apis.mapfilter.Person

fun main() {
    val people = listOf(
        Person("Sandy", 24),
        Person("Monty", 30),
        Person("Bunty", 34),
        Person("Happy", 34))

    val peopleAgeMap = people.groupBy { it.age }
    println(peopleAgeMap)
}