package javastaticreplacements.jvmstatic

import kotlin.jvm.JvmStatic

class Plant {
    companion object {
        @JvmStatic
        fun waterAll() { }
    }
}