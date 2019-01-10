open class User(val nickname: String, val isSubscribed: Boolean = true)

// If your class has a superclass, the primary constructor also needs to initialize the super-class.
class intelliJUser(nickname: String,
                   isSubscribed: Boolean = false,
                   val environmentType: String = "Community Edition") : User(nickname, isSubscribed)

fun main(args: Array<String>) {
    val user1 = User("Sandy")
    println("User: ${user1.nickname} isSubscribed: ${user1.isSubscribed}")

    val user2 = User("Monty", false)
    println("User: ${user2.nickname} isSubscribed: ${user2.isSubscribed}")

    val user3 = User("Bunty", isSubscribed = false)
    println("User: ${user3.nickname} isSubscribed: ${user3.isSubscribed}")

    val intelliJUser = intelliJUser("Brainy", false)
    println("User: ${intelliJUser.nickname} isSubscribed: ${intelliJUser.isSubscribed}" +
            " Environment: ${intelliJUser.environmentType}")
}

