package com.functional.apis.mapfilter

data class Person(val name: String, val age: Int)

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val evens = numbers.filter { it % 2 == 0 }
    println("Original numbers: $numbers")       // Original collection is still intact
    println("Even numbers: $evens")
    println("Squares of evens: ${numbers.filter { it % 2 == 0 }.map { it * it }}")

    val persons = listOf(Person("Sandy", 24), Person("Monty", 30), Person("Bunty", 34))
    println("Only names of persons: ${persons.map { it.name }}")    // Can use Person::name
    println("Only names of persons older than 30: ${persons.filter { it.age > 30 }.map { it.name }}")
}
