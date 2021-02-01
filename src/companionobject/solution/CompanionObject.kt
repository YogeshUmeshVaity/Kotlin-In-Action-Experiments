package companionobject.solution

interface UserDao {
    fun add(user: User)
    fun remove(id: String)
}

/** Cannot inherit from a singleton such as this. */
object UserRetriever { }

class ProfileBuilder { }

data class User(val id: String, val name: String) {
    companion object : UserDao {
        override fun add(user: User) { }
        override fun remove(id: String) { }
    }
}

/**
 * Got rid of the object creation process of UserDao
 */
fun main() {
    val john = User("34", "John")
    User.add(john)
}