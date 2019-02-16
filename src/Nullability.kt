data class Employee(val name: String, val company: Company?)

data class Company(val name: String, val address: Address)

data class Address(val streetAddress: String, val city: String,
                   val zipCode: String, val country: String)

fun main() {
    val sandyCompanyAddress = Address("MountainView", "New York", "48753", "USA")
    val sandyCompany = Company("Google", sandyCompanyAddress)
    val sandy = Employee("Sandy", sandyCompany)

    val monty = Employee("Monty", null)

    // Access data using safe call operator (?.)
    // If the company is not null, call the address method,
    // if the address is not null, call the country method, else return "Unknown instead of 'null'
    val sandyCountry = sandy.company?.address?.country ?: "Unknown"
    println("Sandy's country: $sandyCountry")

    val montyCountry = monty.company?.address?.country ?: "Unknown"
    println("Monty's country: $montyCountry")

    // Without Elvis operator, the expression will return null, if the value is null
    val montyCountryWithoutElvis = monty.company?.address?.country
    println("Monty's country: $montyCountryWithoutElvis")
}
