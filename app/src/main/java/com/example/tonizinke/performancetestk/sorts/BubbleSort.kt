package com.example.tonizinke.performancetestk.sorts

class BubbleSort {
    var timeDiff: Long = 0
        private set
    private var start: Long = 0

    init {
        val liste = ArrayCreator(1, Integer.MAX_VALUE).randomArray
        doWarmUp(liste)
        doTest(liste)
    }

    private fun doWarmUp(liste: IntArray) {
        android.util.Log.d("Warmup", "warmUp gestartet")
        for (j in 0..19)
            testOp(liste)
        android.util.Log.d("Warmup", "warmUp beendet")
    }

    private fun doTest(liste: IntArray) {
        var list = liste
        start = System.nanoTime() / 1000
        list = testOp(list)
        timeDiff = System.nanoTime() / 1000 - start
        for (i in list.indices)
            android.util.Log.i("Array", list[i].toString() + "")

    }

    private fun testOp(liste: IntArray): IntArray = bubblesort(liste)
    private fun bubblesort(x: IntArray): IntArray {
        var unsortiert = true
        var temp: Int

        while (unsortiert) {
            unsortiert = false
            for (i in 0 until x.size - 1)
                if (x[i] > x[i + 1]) {
                    temp = x[i]
                    x[i] = x[i + 1]
                    x[i + 1] = temp
                    unsortiert = true
                }
        }
        return x
    }
}
