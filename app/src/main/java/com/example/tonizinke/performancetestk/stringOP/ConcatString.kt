package com.example.tonizinke.performancetestk.stringOP

class ConcatString(private val o: Int) {
    internal var start: Long = 0
    var conTime: Long = 0

    init {
        doWarmUp()
        doTest()
    }

    private fun doWarmUp() {
        android.util.Log.d("Warmup", "warmUp gestartet")
        for (j in 0..19) testOp()
        android.util.Log.d("Warmup", "warmUp beendet")
    }

    private fun testOp() {
        var s = ""
        for (i in 0 until o) s += i
    }

    private fun doTest() {
        start = System.currentTimeMillis()
        testOp()
        conTime = System.currentTimeMillis() - start
    }
}