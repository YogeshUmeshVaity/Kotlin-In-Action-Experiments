import com.functional.apis.mapfilter.Person

data class Book(val name: String, val authors: List<String>)

fun main() {
    val people = listOf(
        Person("Sandy", 24),
        Person("Monty", 30),
        Person("Bunty", 34),
        Person("Happy", 34))

    // Returns a Map
    val peopleAgeMap = people.groupBy { it.age }
    println(peopleAgeMap)

    /* It's called flatMap because it flattens the Map (a Map like the one returned by groupBy())
     * As a result the flattened Map is converted to a list (which is returned by flatMap())
     * Flattening means combining several lists into one list.
     * The keys of the Map are ignored (or not important) after the operation.
     */
    val strings = listOf("abc", "xyz")
    println(strings.flatMap { it.toList() })

    val books = listOf(
        Book("Thursday Next", listOf("Jasper Fforde")),
        Book("Mort", listOf("Terry Pratchett")),
        Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman")))

    // Groups books by lists of authors
    println(books.groupBy { it.authors })  // returns a Map<List<String>, List<Books>

    // Extracts the specified property for each element(the elements here are lists)
    println(books.map { it.authors })     // returns list of lists

    // Extracts the specified property for each element(the elements here are lists)
    println(books.flatMap { it.authors }) // But this one returns only a single list

    // So both map and flatMap return a list, but
    // map returns list of lists and flatMap returns only one list (flattened list of lists)
}