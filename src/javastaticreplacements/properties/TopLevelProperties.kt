package javastaticreplacements.properties

/**
 * When the independent properties are somewhat related to a class, define them as top-level just
 * before the class declaration:
 */
//const val MAX_ATTEMPTS = 3
//private const val DEFAULT_NAME = "Guest"
//private const val MIN_AGE = 16
//
//data class User(val id: String, val name: String = DEFAULT_NAME)


/**
 * When the properties are closely related to a class, define them inside a `companion object`:
 */
data class User(val id: String, val name: String = DEFAULT_NAME) {
    companion object {
        const val DEFAULT_NAME = "Guest"
        const val MIN_AGE = 16
    }
}