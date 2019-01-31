package com.lambdas.basicssamples

fun printMessageWithError(messages: List<String>, prefix: String) {
    messages.forEach {println("$prefix $it")} // Can access parameters and local vars inside lambda
}

fun countErrorClientServerErrors(messages: List<String>) {
    var clientErrors = 0
    var serverErrors = 0
    messages.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else if(it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client error(s) and $serverErrors server error(s)")
}

fun main() {
    val messages = listOf<String>("404 Page not found", "503 Network disconnected", "200 Extension Error")
    printMessageWithError(messages, "Error:")

    countErrorClientServerErrors(messages)
}