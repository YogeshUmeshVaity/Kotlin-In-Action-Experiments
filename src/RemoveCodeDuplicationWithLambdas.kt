enum class OS { Windows, Mac, Linux, IOS, Android }

data class SiteVisit(val path: String, val visitDuration: Double, val os: OS)

fun main() {
    val visits = listOf(
        SiteVisit("/", 34.0, OS.Windows),
        SiteVisit("/", 20.2, OS.Mac),
        SiteVisit("/login", 12.0, OS.Windows),
        SiteVisit("/signup", 8.0, OS.IOS),
        SiteVisit("/", 16.3, OS.Android))

    // Average duration of visits from Windows machines
    val averageWindowsVisits = visits.filter { it.os == OS.Windows }.map { it.visitDuration }.average()
    println("Average duration of visits from Windows: $averageWindowsVisits")

    // Use a function for above code to avoid code duplication
    val averageAndroidVisits = visits.getAverageVisitsFor(OS.Android)
    println("Average duration of visits from Android: $averageAndroidVisits")

    val averageDurationFromMobile = visits.getAverageDurationFor { it.os in setOf(OS.Android, OS.IOS) }
    println("Average duration of visits from Mobile: $averageDurationFromMobile")

    val averageDurationSignupFromIos = visits.getAverageDurationFor { it.os == OS.IOS && it.path == "/signup" }
    println("Average duration of signup page from IOS: $averageDurationSignupFromIos")
}

// Making this function an extension function improves readability
fun List<SiteVisit>.getAverageVisitsFor(os: OS): Double {
    // filter() is called on List<SiteVisit>
    return filter { it.os == os }.map { it.visitDuration }.average()
}

// Extracting the condition as parameter and passing as a function.
// Now we can query log with more complex conditions.
fun List<SiteVisit>.getAverageDurationFor(predicate: (SiteVisit) -> Boolean): Double {
    return filter(predicate).map { it.visitDuration }.average()
}