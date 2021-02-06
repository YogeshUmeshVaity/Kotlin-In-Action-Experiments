package companionobject.objectvslazy

/**
 * Use lazy { } when you have multiple members to be initialized lazily. So, they will only be
 * initialized when they are actually required and first called, not all at once.
 */
data class User(val id: Long, val name: String) {
    companion object {

        val list by lazy {
            print("Fetching user list...")
            listOf("John", "Jane")
        }

        val settings by lazy {
            print("Fetching user settings...")
            mapOf("Dark Theme" to "On", "Auto Backup" to "On")
        }
    }
}

// Fetching statements will be executed only once.
fun main() {
    println(User.list)      // Fetching user list...[John, Jane]
    println(User.list)      // [John, Jane]
    println(User.settings)  // Fetching settings...{Dark Theme=On, Auto Backup=On}
    println(User.settings)  // {Dark Theme=On, Auto Backup=On}
}