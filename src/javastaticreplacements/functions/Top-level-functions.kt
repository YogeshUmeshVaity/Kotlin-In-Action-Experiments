package javastaticreplacements.functions

/**
 * This is equivalent to the static methods in Java. This first option is often more idiomatic
 * to Kotlin. A better reason to define functions inside `companion object` is when you are
 * extending a companion object, the example is shown in the singleton section.
 */

/**
 * Similar to the properties above, when the functions are somewhat related to a class, define them
 * just above the class:
 */
fun getAllUsers() { }

fun getProfileFor(userId: String) { }

data class User(val id: String, val name: String)

/**
 * When the functions are closely related to a class, define them inside a `companion object`.
 */
//data class User(val id: String, val name: String) {
//    companion object {
//        fun getAllUsers() { }
//        fun getProfileFor(userId: String) { }
//    }
//}
