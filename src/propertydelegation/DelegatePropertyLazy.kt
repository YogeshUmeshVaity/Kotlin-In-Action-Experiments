package propertydelegation.delegatepropertylazy

import propertydelegation.Email

/** This is a costly operation: retrieving from database or making network request.
 * So it cannot be afforded to be initialized early or again and again
 */
fun loadEmails(person: Person): List<Email> {
    println("Loaded emails for $person") // Prints only on initialization
    return listOf(Email("sandy@abc.com"), Email("monty@abc.com"), Email("bunty@abc.com"))
}

data class Person(val name: String) {
    /* The argument of the lazy is a lambda that it calls to initialize the value.
     * lazy() returns an object that has the function getValue(), so, it can use it together
     * with the 'by' keyword.
     */
    val emails by lazy { loadEmails(this) }
}

fun main() {
    val person = Person("Hunty")
    println(person.emails)
    println(person.emails)
}