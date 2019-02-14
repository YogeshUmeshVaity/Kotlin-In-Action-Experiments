import java.lang.StringBuilder

fun alphabet(): String {
    val stringBuilder = StringBuilder()
    with(stringBuilder) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know alphabets")
        return toString()
    }
}

fun main() {
    println(alphabet())
}