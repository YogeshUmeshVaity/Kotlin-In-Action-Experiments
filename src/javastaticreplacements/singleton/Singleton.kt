package javastaticreplacements.singleton

data class User(val id: String, val name: String)

interface UserDao {
    fun add(user: User)
    fun remove(id: String)
}

object UserAccess : UserDao {
    override fun add(user: User) { }
    override fun remove(id: String) { }
}

fun main() {
    val john = User("34", "John")
    UserAccess.add(john)
}