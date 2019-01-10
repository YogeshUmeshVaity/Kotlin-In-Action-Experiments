// Spread operator(*) allows you to pass an array as well as some fixed values at the same time
fun main(args: Array<String>) {
    val list = listOf("args: ", *args)
    println(list)
}