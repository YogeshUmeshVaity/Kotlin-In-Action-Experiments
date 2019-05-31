class Greeter(val greeting: String) {
    operator fun invoke(name: String) {
        println("$greeting, $name")
    }
}

fun main() {
    val englishGreeter = Greeter("Hello")
    englishGreeter("Sandy")
}