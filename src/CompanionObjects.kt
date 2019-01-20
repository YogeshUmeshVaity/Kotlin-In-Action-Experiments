fun getFacebookNickName(facebookId: Int) = "Some name"

class BaseUser private constructor(val nickname: String) {
    companion object {
        // Factory Methods
        fun newSubscribingUser(email: String) = BaseUser(email.substringBefore('@'))
        fun newFacebookUser(facebookId: Int) = BaseUser(getFacebookNickName(facebookId))
    }
}

fun main(args: Array<String>) {
    val facebookUser = BaseUser.newFacebookUser(123)
    println(facebookUser.nickname)

    val subscribingUser = BaseUser.newSubscribingUser("sandy@xyz.com")
    println(subscribingUser.nickname)
}