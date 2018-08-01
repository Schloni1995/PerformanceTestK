package com.example.tonizinke.performancetestj.stringOP

internal object WorstCase {
    @JvmStatic
    fun main(args: Array<String>) {
        var now = System.currentTimeMillis()
        slow()
        println("slow elapsed " + (System.currentTimeMillis() - now) + " ms")

        now = System.currentTimeMillis()
        fast()
        println("fast elapsed " + (System.currentTimeMillis() - now) + " ms")
    }

    fun fast() {
        val s = StringBuilder()
        for (i in 0..99999)
            s.append("*")
    }

    fun slow() {
        var s = ""
        for (i in 0..99999) {
            s += "*"
        }
    }
}