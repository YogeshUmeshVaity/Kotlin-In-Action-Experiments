package com.lambdas.abcxyz

data class Person(val name: String, val age: Int)

fun main() {
    val people = listOf<Person>(Person("Sandy", 24), Person("Monty", 33), Person("Bunty", 27))

    /* maxBy function takes one argument: the function that specifies what values should be compared.
     * The code in curly braces is a lambda that specifies that logic
     */
    println(people.maxBy { it.age })

    /* This is the verbose version of the code above */
    println(people.maxBy(fun(it: Person): Int {
        return it.age
    }))

    /* When lambda just delegates to a function or property
     * it can be replaced by a member reference.
     * In this case, the lambda is delegating to age()
     */
    println(people.maxBy(Person::age))

    /* A lambda expression can declared separately and stored in a variable.
     * And this variable can be treated like a normal function.
     */
    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2))

    /* Function with multiple arguments, one of them is a lambda expression */
    var names = people.joinToString(separator = ", ", transform = { p: Person -> p.name})
    println(names)

    /* Lambda expression can be moved out of the parentheses, while keeping other arguments inside */
    names = people.joinToString(", ") { p: Person -> p.name}
    println(names)

    /* Lambda expression can contain multiple statements, in that case,
     * last expression is the result(return statement)
     */
    val sum2 = { x: Int, y: Int ->
        println("Calculating the sum for $x and $y : ")
        x + y
    }
    println(sum2(3, 4))
}