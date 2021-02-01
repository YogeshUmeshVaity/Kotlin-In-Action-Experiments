package companionobject.problem

interface UserDao {
    fun add(user: User)
    fun remove(id: String)
}


/**
 * While this is a good setup, there are several problems in it:
 * 1. We have an extra step of creating the UserAccess object before we can add/remove a User.
 * 2. Multiple instances of the UserAccess can be created which we don't want. We just want one data
 *    access object for User in the entire application.
 * 3. There is a possiblity of the UserAccess class to be used with or extended with other classes.
 *    So, it doesn't make our intent clear of exactly what we want to do.
 * 4. The naming userAccess.add() or userAccess.addUser() doesn't seem very elegant.
 *    We would prefer something like User.add().
 */
data class User(val id: String, val name: String) {
    class UserAccess : UserDao {
        override fun add(user: User) { }
        override fun remove(id: String) { }
    }
}

fun main() {
    val john = User("34", "John")
    val userAccess = User.UserAccess()
    userAccess.add(john)
}