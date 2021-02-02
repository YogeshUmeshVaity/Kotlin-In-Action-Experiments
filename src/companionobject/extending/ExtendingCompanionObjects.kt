package companionobject.extending

interface UserDao {
    fun add(user: User)
    fun remove(id: String)
}

data class User(val id: String, val name: String) {
    companion object : UserDao {
        override fun add(user: User) { }
        override fun remove(id: String) { }
    }
}

// class Admin : User.Companion() { }  // Error: can't extend from a singleton


fun User.Companion.isLoggedIn(id: String): Boolean { return false }

fun main() {
    if (User.isLoggedIn("34")) { /* Allow content */ }
}

