package com.example.tonizinke.performancetestk.stringOP

class ConcatString(private val o: Int) : Runnable {
    internal var start: Long = 0
    /** @return the conTime
     */
    var conTime: Long = 0


    override fun run() {
        start = System.currentTimeMillis()
        var s = ""
        for (i in 0 until o) {
            s += i
        }
        // System.out.println(s);
        conTime = System.currentTimeMillis() - start
    }
}