package com.example.tonizinke.performancetestk.stringOP

class BuildString(private val o: Int) {
    internal var start: Long = 0
    var sbTime: Long = 0
    private var sb = StringBuilder()

    init {
        doWarmUp()
        doTest()
    }

    private fun doWarmUp() {
        android.util.Log.d("Warmup", "warmUp gestartet")
        for (j in 0..19) testOp()
        android.util.Log.d("Warmup", "warmUp beendet")
    }

    private fun doTest() {
        start = System.currentTimeMillis()
        sb = StringBuilder()
        testOp()
        sbTime = System.currentTimeMillis() - start
    }

    private fun testOp() {
        for (i in 0 until o)
            sb.append(i)
        val s = sb.toString()
    }
}