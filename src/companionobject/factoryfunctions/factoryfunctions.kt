package companionobject.factoryfunctions

/**
 * Notice how the constructor is kept private but the companion object has access to the constructor.
 * This is useful when you want to provide multiple ways to create an object where the object
 * construction process is complex.
 *
 * In the code above, consistency of the next id generation is guaranteed because a companion object
 * is a singleton, only one object will keep track of the id, there won't be any duplicate ids.
 *
 * Also notice that companion objects can have properties (currentId in this case) to represent state.
 */
class User private constructor(val id: Long, val name: String) {
    companion object {
        private var currentId = 0L;
        fun from(name: String) = User(currentId++, name)
    }

    override fun toString(): String {
        return "id: $id, name: $name"
    }
}

fun main() {
    val john = User.from("John")
    println(john)
    val jane = User.from("Jane")
    println(jane)
}