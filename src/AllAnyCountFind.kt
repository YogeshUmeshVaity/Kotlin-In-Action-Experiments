import com.functional.apis.mapfilter.Person

fun main() {
    val persons = listOf(
        Person("Sandy", 24),
        Person("Monty", 30),
        Person("Bunty", 34),
        Person("Happy", 34))

    /* Define predicate separately.
     * Note: here since, the compiler doesn't know what type of object it's dealing with,
     * you need to specify the object type explicitly. Can't use it.age
     */
    val canBeInClub30 = { person: Person -> person.age <= 30}
    println("Can all persons be in club of 30 : ${persons.all(canBeInClub30)}")
    println("Can any person be in club of 30 : ${persons.any(canBeInClub30)}")

    val numbers = listOf(1, 2, 3)
    /* Both mean the same thing. For readability choose a function that doesn't require
     * you to put a negation sign before it.
     */
    println("Are all elements not equal to 3 ? : ${!numbers.all { it == 3 }}")
    println("Is any element not equal to 3 ? : ${numbers.any { it != 3 }}")
}