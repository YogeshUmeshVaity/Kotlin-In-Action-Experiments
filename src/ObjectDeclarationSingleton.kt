import java.io.File

//Singleton object
object CaseInsensitiveComparator : Comparator<File> {
    override fun compare(f1: File, f2: File): Int {
        return f1.path.compareTo(f2.path, ignoreCase = true)
    }
}

// You can also declare objects in a class. Such objects also have just a single instance;
// they don’t have a separate in stance per instance of the containing class.
data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int {
            return p1.name.compareTo(p2.name)
        }
    }
}

fun main(args: Array<String>) {
    val fileList = listOf<File>(File("/z"), File("/a"), File("/A"))
    println(fileList.sortedWith(CaseInsensitiveComparator))

    val personList = listOf<Person>(Person("Sandy"), Person("Monty"))
    println(personList.sortedWith(Person.NameComparator))
}