package com.example.tonizinke.performancetestj.stringOP

class ConcatString(private val o: Int) : Runnable {
    internal var start: Long = 0
    /** @return the conTime
     */
    var conTime: Long = 0
        private set

    override fun run() {
        start = System.currentTimeMillis()
        for (i in 0 until o) {
        }
        // System.out.println(s);
        conTime = System.currentTimeMillis() - start
    }
}