package com.example.tonizinke.performancetestk.KotlinPower

class MyClass {
    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}
val instance = MyClass.create()

//Quelle: https://kotlinlang.org/docs/reference/object-declarations.html#companion-objects
//Offizielle Kotlin-Dokumentation

