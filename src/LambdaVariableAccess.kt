package com.lambdas.basicssamples

fun printMessageWithError(messages: List<String>, prefix: String) {
    messages.forEach {println("$prefix $it")} // Can access parameters and local vars inside lambda
}

fun main() {
    val messages = listOf<String>("404 Page not found", "403 Network disconnected")
    printMessageWithError(messages, "Error:")
}