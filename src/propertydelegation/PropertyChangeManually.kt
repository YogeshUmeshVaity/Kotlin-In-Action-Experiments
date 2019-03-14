package propertydelegation.propertychange

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class Person(val name: String, age: Int, salary: Int) : PropertyChangeAware() {

    // Observer here specifies what to do when the even occurs
    private val observer = { property: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(property.name, oldValue, newValue)
    }
    // The object to the right of the 'by' is called delegate. Kotlin stores the delegate
    // in a hidden property and calls getValue() and setValue() on the delegate when you
    // access or modify the main property.
    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
}

fun main() {
    val person = Person("Sandy", 24, 25000)
    person.addPropertyChangeListener(
        PropertyChangeListener { event ->
            println("${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
        })
    person.salary = 30000 // Change the property
    person.age = 25
}