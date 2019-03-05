import java.time.LocalDate

fun main() {
    val now = LocalDate.now()
    // Building range of dates
    val vacation = now..now.plusDays(10)
    println("Is the next 1 week within the vacation? : ${now.plusWeeks(1) in vacation}")
    println("Are the next 2 weeks within the vacation? : ${now.plusWeeks(2) in vacation}")
}