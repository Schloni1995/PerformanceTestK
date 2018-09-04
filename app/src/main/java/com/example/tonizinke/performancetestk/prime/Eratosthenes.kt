package com.example.tonizinke.performancetestk.prime

class Eratosthenes(zahl: Int) {
    var timeDiff: Long = 0
        private set

    init {
        doWarmUp(zahl)
        doTest(zahl)
    }

    private fun doWarmUp(zahl: Int) {
        android.util.Log.d("Warmup", "warmUp gestartet")
        for (i in 0..19) testOp(zahl)
        android.util.Log.d("Warmup", "warmUp beendet")
    }

    private fun testOp(zahl: Int) {
        var z = zahl
        aussieben(++z)
    }

    private fun doTest(zahl: Int) {
        val start = System.currentTimeMillis()
        testOp(zahl)
        timeDiff = System.currentTimeMillis() - start
    }

    companion object {
        fun aussieben(zahl: Int) {
            val prim = BooleanArray(zahl)
            for (i in 2 until zahl) prim[i] = true

            var i = 2
            while (i * i < zahl) {
                if (prim[i]) {
                    print(i.toString() + " ")
                    var j = i * i
                    while (j < zahl) {
                        prim[j] = false
                        j += i
                    }
                }
                i++
            }
            while (i < zahl) {
                if (prim[i]) {
                    print(i.toString() + " ")
                }
                i++
            }
        }
    }
}