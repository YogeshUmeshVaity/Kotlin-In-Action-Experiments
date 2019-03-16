package propertydelegation.expando

/**
 * Expando object is an object in which properties are created dynamically.
 * Each object has arbitrary properties.
 * In this class, we store all the attributes of a Person in a Map and provide properties
 * for accessing the information that requires special handling.
 */
class Person {
    val _attributes = HashMap<String, String>()
    fun setAttribute(name: String, value: String) {
        _attributes[name] = value
    }
    // This works because Kotlin Standard Library defines extension functions
    // getValue() and setValue() on Map and MutableMap interfaces.
    val name: String by _attributes
}

fun main() {
    val data = hashMapOf("name" to "Sandy", "company" to "KLW")
    // Create an object that has only one property: that is 'name'
    val person = Person()
    for((propertyName, propertyValue) in data) {
        person.setAttribute(propertyName, propertyValue)
    }
    println("person name: ${person.name}")
}