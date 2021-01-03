package recursivetypebounds.kotlin.returningtypes

interface VitaminSource<T: VitaminSource<T>> {
    fun getSource(): T {
        // Suppress the unchecked cast because generics are erased at runtime.
        @Suppress("UNCHECKED_CAST")
        return this as T
    }
}

class Carrot : VitaminSource<Carrot> {
    fun getVitaminA() = println("Vitamin A")
}

class Banana : VitaminSource<Banana> {
    fun getVitaminB() = println("Vitamin B")
}

fun main() {
    val carrot = Carrot().getSource()
    carrot.getVitaminA()

    val banana = Banana().getSource()
    banana.getVitaminB()
}

