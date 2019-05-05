import com.functional.apis.mapfilter.Person
import kotlin.reflect.full.memberProperties
import kotlin.reflect.KFunction2

fun main() {
    val person = Person("Sandy", 24)
    val kClass = person.javaClass.kotlin    // Returns an instance of KClass<Person>
    kClass.memberProperties.forEach { println(it.name) }

    // 2 indicates that this function takes 2 parameters
    val kFunction: KFunction2<Int, Int, Int> = ::sum
    println(kFunction.invoke(2, 4))
}

fun sum(x: Int, y: Int) = x + y