import java.time.LocalDate
// for loop under the hood uses the iterator() function to iterate over elements.
// So if you want to create a range of elements of your class, this is how you implement iterator operator.
// LocalDate is your class here, which is the type argument.
operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> {
    return object : Iterator<LocalDate> {
        var current = start

        override fun hasNext(): Boolean {
            return current <= endInclusive
        }

        // apply() first returns the current date and then
        // changes the reference to refer to the next date
        override fun next() = current.apply {
            current = plusDays(1)
        }
    }
}

fun main() {
    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(1)..newYear
    for (dayOff in daysOff) {
        println(dayOff)
    }
}