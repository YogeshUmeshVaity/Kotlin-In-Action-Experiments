sealed class Expr1 {
    class Num1(val value: Int): Expr1()
    class Sum1(val left: Expr1, val right: Expr1): Expr1()
}

fun eval(e: Expr1): Int = when(e) {
    is Expr1.Num1 -> e.value                                         // Check argument type, smart casts are applied.
    is Expr1.Sum1 -> eval(e.left) + eval(e.right)
}

fun evalWithLogging(e: Expr1): Int = when(e) {
    is Expr1.Num1 -> {
        println("Num: ${e.value}")
        e.value
    }
    is Expr1.Sum1 -> {
        val left = evalWithLogging(e.left)
        val right = evalWithLogging(e.right)
        println("Sum: $left + $right")
        left + right
    }
}

fun main(args: Array<String>) {
    println(evalWithLogging(Expr1.Sum1(Expr1.Sum1(Expr1.Num1(1), Expr1.Num1(2)), Expr1.Num1(4))))
}