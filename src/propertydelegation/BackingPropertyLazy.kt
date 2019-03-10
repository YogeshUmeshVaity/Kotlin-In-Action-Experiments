package propertydelegation

data class Email(val address: String)

/** This is a costly operation: retrieving from database or making network request.
 * So it cannot be afforded to be initialized early or again and again
 */
fun loadEmails(person: Person): List<Email> {
    println("Loaded emails for $person") // Prints only on initialization
    return listOf(Email("sandy@abc.com"), Email("monty@abc.com"), Email("bunty@abc.com"))
}

/**
 * Explains lazy initialization using a backing property.
 * _emails is the backing property here.
 * This approach makes the code too verbose, imagine if there were many more properties were to be implemented
 */
data class Person(val name: String) {
    private var _emails: List<Email>? = null

    val emails: List<Email>
        get() {
            if (_emails == null) {
                _emails = loadEmails(this)
            }
            return _emails!!
        }
}

fun main() {
    val person = Person("Hunty")
    println(person.emails)
    println(person.emails)
}