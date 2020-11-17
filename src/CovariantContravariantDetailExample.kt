

open class Animal {
    fun feed() { println("Animal is being fed") }
}

/**
 * With the 'out' keyword before type parameter, typeprojection.Herd class is covariant.
 * So, the typeprojection.Herd<Cat> is a subtype of typeprojection.Herd<Animal> and the you can pass typeprojection.Herd<Cat>
 * to the feedAll function which takes typeprojection.Herd<Animal> as its parameter.
 *
 * If you remove the 'out' keyword, the typeprojection.Herd class becomes invariant.
 * So, the typeprojection.Herd<Cat> is not a subtype of typeprojection.Herd<Animal> anymore.
 * And if you try to pass typeprojection.Herd<Cat> to feedAll you get type-mismatch error.
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

open class Cat : Animal() {
    fun cleanLitter() { println("Litter is being cleaned") }
    fun catchRat() { println("Cat is catching rat") }
}

fun takeCareOfCats(cats: Herd<Cat>) {
    for (i in 0 until cats.size) {
        cats[i].cleanLitter()
    }
    feedAll(cats)
}

class PersianCat : Cat() { }

class RussianCat : Cat() { }

// Contravariant
class RatCatcherGroup<in T : Cat> {
    private val ratCatchers = mutableListOf<T>()

    fun add(ratCatcher: T) {
        ratCatchers.add(ratCatcher)
    }

    fun sendAllToCatch() {
        ratCatchers.forEach(Cat::catchRat)
    }
}

fun main() {
    // Covariant Test
    val cats = Herd<Cat>()
    takeCareOfCats(cats)

    // Contravariant Test
    val persianCat = PersianCat()
    val russianCat = RussianCat()
    val animal = Animal()
    val catchers = RatCatcherGroup<Cat>()
    catchers.add(persianCat)
    catchers.add(russianCat)
    // catchers.add(animal) // Error
    catchers.sendAllToCatch()
}