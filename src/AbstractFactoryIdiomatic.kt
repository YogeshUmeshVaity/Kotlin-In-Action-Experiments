interface FoodFactory<T> {
    fun cookFood() : T
}

class Pizza() {
    init {
        println("A pizza has been cooked")
    }
    companion object : FoodFactory<Pizza> {         // PizzaFactory
        override fun cookFood(): Pizza = Pizza()
    }
}

class Burger() {
    init {
        println("A burger has been cooked")
    }
    companion object : FoodFactory<Burger> {        // BurgerFactory
        override fun cookFood(): Burger = Burger()
    }
}

fun <T> getFood(factory: FoodFactory<T>) : T {
    return factory.cookFood()
}

fun main() {
    // The name of the Burger class is used as an instance of FoodFactory
    val burger1 = getFood(Burger)
    val pizza1 = getFood(Pizza)
}