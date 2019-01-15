/*
class Customer(private val name: String, private val id: String) {

    override fun toString() = "Name:${name.toString()} ID:${id.toString()}"

    override fun equals(other: Any?): Boolean {
        if(other == null || other !is Customer) return false
        return this.name == other.name && this.id == other.id
    }

    override fun hashCode(): Int {
        return name.hashCode() * 31 + id.hashCode() * 31
    }
}*/

// The compiler generates the above methods in a data class
data class Customer(val name: String, val id: String)

fun main(args: Array<String>) {
    val customer1 = Customer("Sandy", "6412")
    //Test toString
    println(customer1)

    //Test Equality
    val customer2 = Customer("Sandy", "6412")
    println("Equality: Are two objects equal: ${customer1 == customer2}")

    //Test Equality
    val customer3 = Customer("Sandy", "6413")
    println("Equality: Are two objects equal: ${customer1 == customer3}")

    // Test Hash equality
    val customerList = hashSetOf(customer1, customer2, customer3)
    println("Hash equality: 3 objects added. How many customers in HashSet: ${customerList.size}")
}