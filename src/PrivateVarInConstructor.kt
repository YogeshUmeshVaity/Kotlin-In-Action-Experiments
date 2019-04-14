class Musician(private var name: String)

fun main() {
    val musicianDrv = Musician("Drv")
    /**
     * Cannot get or set the property value if it is declared private in constructor.
     * It can be set only during construction.
     */
    // musicianDrv.name = "Drvn"
    // println("Musician: ${musicianDrv.name}")
}