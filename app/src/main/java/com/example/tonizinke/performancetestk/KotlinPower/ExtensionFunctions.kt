package com.example.tonizinke.performancetestk.KotlinPower

val <T> List<T>.lastIndex: Int
    get() = size - 1

fun ExtensionFunctions():Int
{
    var list = intArrayOf(1,2,3)
    return list.lastIndex
}
