/*
class DelegatingCollection<T> : Collection<T> {
    val innerList = ArrayList<T>()

    override val size: Int
        get() = innerList.size
    override fun contains(element: T): Boolean = innerList.contains(element)
    override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)
    override fun isEmpty(): Boolean = innerList.isEmpty()
    override fun iterator(): Iterator<T> = innerList.iterator()

    fun add(element: T): Boolean {
        return innerList.add(element)
    }

    override fun toString(): String {
        return innerList.toString()
    }
}
*/

// Above functionality can be delegated to an object using the 'by' keyword
class DelegatingCollection<T>(val innerList: MutableCollection<T> = ArrayList<T>())
    : MutableCollection<T> by innerList {
    override fun toString(): String {
        return innerList.toString()
    }
}

fun main(args: Array<String>) {
    val list = DelegatingCollection<String>()
    list.add("abc")
    list.add("xyz")
    println(list)
    println("Size: ${list.size}")
    println("Does it contain \"abc\"? : ${list.contains("abc")}")
}