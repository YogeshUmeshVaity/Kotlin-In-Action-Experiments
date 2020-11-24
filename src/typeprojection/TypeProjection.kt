package typeprojection

class Crate<T>(private val elements: MutableList<T>) {
    fun add(t: T) = elements.add(t)     // Consumer allowed
    fun last(): T = elements.last()     // Producer not allowed: Error
}

open class Fruit

open class CitrusFruit : Fruit()

class Orange : CitrusFruit()

fun main() {
    // Only Fruit allowed(no subtyping) because it's invariant
    val invariantCrate: Crate<Fruit> = Crate<Fruit>(mutableListOf(Fruit(), Orange()))
    invariantCrate.add(Orange())         // Consumer allowed
    invariantCrate.last()                // Producer allowed

    // Subtyping allowed because it's covariant
    val covariantCrate: Crate<out Fruit> = Crate<CitrusFruit>(mutableListOf(Orange()))
//  covariantCrate.add(Fruit())         // Consumer not allowed: Error
    covariantCrate.last()               // Producer allowed

    // Subtyping allowed because it's contravariant
    val contravariantCrate: Crate<in Orange> = Crate<CitrusFruit>(mutableListOf(Orange(), CitrusFruit()))
    contravariantCrate.add(Orange())    // Consumer allowed
    contravariantCrate.last()           // Producer allowed: No Error?

    /* Explanation at: https://stackoverflow.com/questions/64835413/type-projections-in-kotlin-different-behaviour-for-use-site-and-declaration-sit */

    val starCovariantCrate: Crate<*> = Crate<CitrusFruit>(mutableListOf(Orange()))
//  starCovariantCrate.add(Fruit())           // Consumer not allowed
    starCovariantCrate.last()

    val starContraCrate: Crate<*> = Crate<CitrusFruit>(mutableListOf(Orange(), CitrusFruit()))
//  starContraCrate.add(Orange())             // Consumer not allowed
    starContraCrate.last()
}