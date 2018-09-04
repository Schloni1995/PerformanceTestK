package com.example.tonizinke.performancetestk.maths

class Leibnitzreihe {
    var start: Long = 0
    var end: Long = 0
    private var loopMax: Long = 10000000

    init {
        doWarmUp()
        doTest()
    }

    private fun doWarmUp() {
        for (j in 0..19) leibnitz()
    }

    private fun doTest() {
        start = System.currentTimeMillis()
        leibnitz()
        end = System.currentTimeMillis()
    }

    private fun leibnitz() {
        var zahl = 0.0
        var x = 1.0
        var b = false

        var i = 1
        while (i <= loopMax) {
            if (!b) {
                zahl = +(1 / x)
                b = true
            } else {
                zahl = -(1 / x)
                b = false
            }
            i++
            x = (+2).toDouble()
        }
    }

    fun timeDiff(): Long = end - start
}
