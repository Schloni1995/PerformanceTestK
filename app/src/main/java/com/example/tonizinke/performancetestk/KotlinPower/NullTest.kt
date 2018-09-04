package com.example.tonizinke.performancetestk.KotlinPower

fun check():Unit //hier optional
{
    var a: String = "abc"
    a = null // Fehler
    //Set-nullable-Operator
    var b: String? = "abc"
    b = null // In Ordnung
    val le = b.length //Fehler, weil b null sein kann
    //Safecall-Operator
    val c: String? = null // c darf null sein
    println(c?.length) // Wenn c nicht null, dann Ausgabe, sonst null
    //Elvisoperator
    val l = b?.length ?: -1 // Sollte die Länge von b null sein, dann weise -1 zu
}