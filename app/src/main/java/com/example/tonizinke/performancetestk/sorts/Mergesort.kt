package com.example.tonizinke.performancetestk.sorts

class Mergesort {
    var timeDiff: Long = 0
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

    private fun testOp(liste: IntArray): IntArray = sort(liste, 0, liste.size - 1)

    private fun sort(tempListe: IntArray, l: Int, r: Int): IntArray {
        var tempList = tempListe
        if (l < r) {
            val q = (l + r) / 2
            tempList = sort(tempList, l, q)
            tempList = sort(tempList, q + 1, r)
            tempList = merge(tempList, l, q, r)
        }
        return tempList
    }

    private fun merge(tempList: IntArray, l: Int, q: Int, r: Int): IntArray {
        val arr = IntArray(tempList.size)
        var i: Int = l
        var j: Int = q + 1
        while (i <= q) {
            arr[i] = tempList[i]
            i++
        }
        while (j <= r) {
            arr[r + q + 1 - j] = tempList[j]
            j++
        }
        i = l
        j = r
        for (k in l..r)
            if (arr[i] <= arr[j])
                tempList[k] = arr[i++]
            else
                tempList[k] = arr[j--]
        return tempList
    }
}
