fun main() {
    val numbers = listOf(1, 2, 3, 4)

    /* Lazy operation: map, find - map, find - map, find and so on
     * Eager operation: map, map, map - find, find, find and so on
     * So, some elements don't need to be precessed at all,
     * hence sequences(lazy operations) can be more efficient.
     */
    println(numbers.asSequence().map {it * it}.find { it > 3 })


    val people = listOf(Person("abc"), Person("vwxyz"), Person("pqr"), Person("lmnopqrs"))

    // Order of operations is important
    // Here map, map, map, map - filter, filter, filter, filter
    println(people.map { it.name }.filter { it.length < 4 })

    // Here filter, filter, filter, filter - map, map
    // only 2 map operations required, hence more efficient
    println(people.filter { it.name.length < 4 }.map { it.name })
}