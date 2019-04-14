open class Animal {
    fun feed() { println("Animal is being fed") }
}

/**
 * With the 'out' keyword before type parameter, Herd class is covariant.
 * So, the Herd<Cat> is a subtype of Herd<Animal> and the you can pass Herd<Cat>
 * to the feedAll function which takes Herd<Animal> as its parameter.
 *
 * If you remove the 'out' keyword, the Herd class becomes invariant.
 * So, the Herd<Cat> is not a subtype of Herd<Animal> anymore.
 * And if you try to pass Herd<Cat> to feedAll you get type-mismatch error.
 */
class Herd<out T : Animal> {
    private val animalList = listOf<T>()
    val size: Int get() = animalList.size

    operator fun get(position: Int): T {
        return animalList[position]
    }
}

fun feedAll(animals: Herd<Animal>) {
    for (i in 0 until animals.size) {
        animals[i].feed()
    }
}

class Cat : Animal() {
    fun cleanLitter() { println("Litter is being cleaned") }
}

fun takeCareOfCats(cats: Herd<Cat>) {
    for (i in 0 until cats.size) {
        cats[i].cleanLitter()
    }
    feedAll(cats)
}

fun main() {
    val cats = Herd<Cat>()
    takeCareOfCats(cats)
}