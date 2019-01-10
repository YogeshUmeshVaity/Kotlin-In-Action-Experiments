interface Expr
class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr

fun eval(e: Expr): Int = when(e) {
    is Num -> e.value                                         // Check argument type, smart casts are applied.
    is Sum -> eval(e.left) + eval(e.right)
    else -> throw IllegalArgumentException("Unknown Expression")
}

fun evalWithLogging(e: Expr): Int = when(e) {
    is Num -> {
        println("Num: ${e.value}")
        e.value
    }
    is Sum -> {
        val left = evalWithLogging(e.left)
        val right = evalWithLogging(e.right)
        println("Sum: $left + $right")
        left + right
    }
    else -> throw IllegalArgumentException("Unknown Expression")
}

fun main(args: Array<String>) {
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}