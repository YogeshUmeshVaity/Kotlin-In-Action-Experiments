import com.functional.apis.mapfilter.Person
import kotlin.reflect.full.memberProperties

fun main() {
    val person = Person("Sandy", 24)
    val kClass = person.javaClass.kotlin    // Returns an instance of KClass<Person>
    kClass.memberProperties.forEach { println(it.name) }
}