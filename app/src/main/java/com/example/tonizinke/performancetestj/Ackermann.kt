package com.example.tonizinke.performancetestj

object Ackermann {
    internal val NANO = 0.000000001

    fun ackITT(n: Long, m: Long): Long {
        var n = n
        var m = m
        while (n != 0L) {
            if (m == 0L)
                m = 1
            else
                m = ackITT(n, m - 1)
            n--
        }
        return m + 1
    }

    fun ackREK(n: Long, m: Long): Long {
        return if (n == 0L)
            m + 1
        else

            if (m == 0L)
                ackREK(n - 1, 1)
            else
                ackREK(n - 1, ackREK(n, m - 1))

    }

    private fun test() {
        val x = 3
        val y = 0
        var end: Long
        var start = System.nanoTime()
        ackREK(x.toLong(), y.toLong())
        end = System.nanoTime()
        println("REK " + (end - start) * NANO)

        start = System.nanoTime()
        ackITT(x.toLong(), y.toLong())
        end = System.nanoTime()
        println("ITT " + (end - start) * NANO)
    }

}
