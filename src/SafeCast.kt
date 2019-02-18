package safecast

class Person(val firstName: String, val lastName: String) {
    override fun equals(other: Any?): Boolean {
        // If the cast fails, safe cast operator (as?) returns null, and if left value is null,
        // Elvis operator returns the replacement (in this case, it returns false)
        val otherPerson = other as? Person ?: return false
        return otherPerson.firstName == firstName &&
                otherPerson.lastName == lastName
    }

    override fun hashCode(): Int {
        return firstName.hashCode() * 37 + lastName.hashCode()
    }
}

fun main() {
    val person1 = Person("Sandy", "Dmx")
    val person2 = Person("Sandy", "Dmx")

    println(person1 == person2)
}