package outandinkeywords

open class Weapon

open class Rifle : Weapon()

class SniperRifle : Rifle()

/**
 * Invariant
 */
class Case<T> {
    private val contents = mutableListOf<T>()
    fun produce(): T = contents.last()         // Producer allowed
    fun consume(item: T) = contents.add(item)  // Consumer allowed
}

class Case1<out T> {
    private val contents = mutableListOf<T>()
    fun produce(): T = contents.last()         // Producer allowed
//  fun consume(item: T) = contents.add(item)  // Error: Consumer not allowed
}

class Case2<in T> {
    private val contents = mutableListOf<T>()
//  fun produce(): T = contents.last()         // Error: Producer not allowed
    fun consume(item: T) = contents.add(item)  // Consumer allowed
}

fun useProducerConsumer(case: Case<Rifle>) {
    // Produces Rifle and its subtypes
    case.produce()
    // Consumes Rifle and its subtypes
    case.consume(SniperRifle())
}

fun useProducer(case: Case1<Rifle>) {
    // Produces Rifle and its subtypes
    val rifle = case.produce()
}

fun useConsumer(case: Case2<Rifle>) {
    // Consumes Rifle and its subtypes
    case.consume(Rifle())
    case.consume(SniperRifle())
}

fun main() {
//  useProducerConsumer(Case<SniperRifle>())
    useProducerConsumer(Case<Rifle>())
//  useProducerConsumer(Case<Weapon>())

//  useProducer(Case1<Weapon>())
    useProducer(Case1<Rifle>())
    useProducer(Case1<SniperRifle>())             // OK: Regular subtyping allowed

    useConsumer(Case2<Weapon>())            // OK: Reverse subtyping allowed
    useConsumer(Case2<Rifle>())
//  useConsumer(Case2<SniperRifle>())       // Error: Regular subtyping not allowed
}