interface InternetUser {
    val nickname: String
}

class PrivateUser(override val nickname: String) : InternetUser

class SubscribingUser(val email: String) : InternetUser {
    override val nickname: String
        get() = email.substringBefore('@')
}

class FacebookUser(accountId: String) : InternetUser {
    override val nickname: String = getFacebookName(accountId)
}

// Costly function, connects to internet to get name
fun getFacebookName(accountId: String) = "Some name"

fun main(args: Array<String>) {
    println("Private User: ${PrivateUser("Sandy").nickname}")
    println("SubscribingUser: ${SubscribingUser("Monty1981@gmail.com").nickname}")
    println("FacebookUser: ${FacebookUser("abc453").nickname}")
}