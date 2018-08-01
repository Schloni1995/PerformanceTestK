package com.example.tonizinke.performancetestk.stringOP

class BuildString(private val o: Int) : Runnable {
    internal var start: Long = 0
    /** @return the sbTime
     */
    var sbTime: Long = 0


    override fun run() {
        start = System.currentTimeMillis()
//        start = System.nanoTime()
        val sb = StringBuilder()
        for (i in 0 until o)
            sb.append(i)
        // System.out.println(sb.toString());
        val s = sb.toString()
        sbTime = System.currentTimeMillis() - start
//        sbTime = System.nanoTime() - start
    }
}