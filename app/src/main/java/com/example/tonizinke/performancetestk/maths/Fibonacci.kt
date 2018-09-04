package com.example.tonizinke.performancetestk.maths

class Fibonacci(n: Long) {
    var timeDiff: Long = 0

    init {
        val start = System.currentTimeMillis()
        for (i in 1..n)
            fibonacci(i.toInt())
        timeDiff = System.currentTimeMillis() - start
    }

    fun fibonacci(n: Int): Long {
        return if (n <= 1)
            n.toLong()
        else
            fibonacci(n - 1) + fibonacci(n - 2)
    }
}
