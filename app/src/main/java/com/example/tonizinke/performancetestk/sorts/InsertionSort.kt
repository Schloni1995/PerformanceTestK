package com.example.tonizinke.performancetestk.sorts

class InsertionSort {
    var timeDiff: Long = 0
        private set
    private var start: Long = 0

    init {
        val liste = ArrayCreator(1, Integer.MAX_VALUE).randomArray
        doWarmUp(liste)
        doTest(liste)
    }

    private fun doTest(liste: IntArray) {
        var list = liste
        start = System.nanoTime() / 1000
        list = testOp(list)
        timeDiff = System.nanoTime() / 1000 - start
        for (i in list.indices)
            android.util.Log.i("Array", list[i].toString() + "")
    }

    private fun doWarmUp(liste: IntArray) {
        android.util.Log.d("Warmup", "warmUp gestartet")
        for (j in 0..19) {
            testOp(liste)
        }
        android.util.Log.d("Warmup", "warmUp beendet")
    }

    private fun testOp(liste: IntArray): IntArray =insertionSort(liste)

    private fun insertionSort(sortieren: IntArray): IntArray {
        var temp: Int
        for (i in 1 until sortieren.size) {
            temp = sortieren[i]
            var j = i
            while (j > 0 && sortieren[j - 1] > temp) {
                sortieren[j] = sortieren[j - 1]
                j--
            }
            sortieren[j] = temp
        }
        return sortieren
    }
}
