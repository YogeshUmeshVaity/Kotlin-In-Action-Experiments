package propertydelegation.propertychange

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

/**
 * In this class, we store the value of the property and automatically fire the property change event.
 */
class ObservableProperty(
    private val propertyName: String, private var propertyValue: Int,
    private val changeSupport: PropertyChangeSupport) {

    fun getValue() = propertyValue
    fun setValue(newValue: Int) {
        val oldValue = propertyValue
        propertyValue = newValue
        changeSupport.firePropertyChange(propertyName, oldValue, newValue)
    }
}

class Person(val name: String, age: Int, salary: Int) : PropertyChangeAware() {

    /**
     * We removed the repeated code, but quite a bit of code is required to create the
     * ObservableProperty instance for each property and to delegate the getter and setter to it.
     */
    private val _age = ObservableProperty("age", age, changeSupport)
        var age: Int
            get() = _age.getValue()
            set(value) = _age.setValue(value)

    private val _salary = ObservableProperty("salary", salary, changeSupport)
        var salary: Int
            get() = _salary.getValue()
            set(value) = _salary.setValue(value)
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