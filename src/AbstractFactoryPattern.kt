import java.lang.IllegalArgumentException

// Our factories are going to produce objects of type Cook
interface Cook {
    val name: String
    fun cook()
}

// BurgerCook is created by the BurgerCookFactory
interface BurgerCook : Cook

// PizzaCook is created by the PizzaCookFactory
interface PizzaCook : Cook

// The CookFactory is the base interface for our Factory
interface CookFactory {
    fun getInstance(name: String) : Cook
}

/**
 * This is how abstract factory pattern is a factory of factory.
 * Here the BurgerCookFactory creates Cook and the Cook creates Burger
 */
class BurgerCookFactory : CookFactory {
    override fun getInstance(name: String): BurgerCook =
            when(name) {
                "Bob"  -> Bob()
                "Tina" -> Tina()
                else   -> throw IllegalArgumentException("No class available for $name")
            }

    class Tina : BurgerCook {
        override val name: String
            get() = "Tina"

        override fun cook() {
            println("$name is Cooking the Burger")
        }
    }

    private class Bob : BurgerCook {
        override val name: String
            get() = "Bob"

        override fun cook() {
            println("$name is Cooking the Burger")
        }
    }
}

class PizzaCookFactory : CookFactory {
    override fun getInstance(name: String): Cook =
            when(name) {
                "Jimmy" -> Jimmy()
                "Sandy" -> Sandy()
                else -> throw IllegalArgumentException("No class available for $name")
            }

    class Sandy : Cook {
        override val name: String
            get() = "Sandy"

        override fun cook() {
            println("$name is Cooking the Pizza")
        }
    }

    class Jimmy : Cook {
        override val name: String
            get() = "Jimmy"

        override fun cook() {
            println("$name is Cooking the Pizza")
        }
    }
}

fun createCook(factory: CookFactory, name: String) : Cook = factory.getInstance(name)

fun main(args: Array<String>) {
    val burgerSandy = createCook(PizzaCookFactory(), "Sandy")
    burgerSandy.cook()

    val pizzaBom = createCook(BurgerCookFactory(), "Bob")
    pizzaBom.cook()
}