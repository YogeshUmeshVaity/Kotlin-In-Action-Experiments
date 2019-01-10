interface Clickable {
    fun click()
    fun showOff() = println("I'm Clickable")
}

interface Focusable {
    fun setFocus(isFocused: Boolean)
    fun showOff() = println("I'm Focusable")
}

class Button : Clickable, Focusable {
    override fun click() {
        println("I was clicked")
    }

    override fun setFocus(isFocused: Boolean) {
        println("I have ${if (isFocused) "focus" else "no focus"}")
    }

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main(args: Array<String>) {
    val button = Button()
    button.click()
    button.setFocus(true)
    button.setFocus(false)
    button.showOff()
}