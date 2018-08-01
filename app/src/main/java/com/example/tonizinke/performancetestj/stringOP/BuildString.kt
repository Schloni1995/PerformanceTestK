package com.example.tonizinke.performancetestj.stringOP

class BuildString(private val o: Int) : Runnable {
    internal var start: Long = 0
    /** @return the sbTime
     */
    var sbTime: Long = 0
        private set

    override fun run() {
        start = System.currentTimeMillis()
        val sb = StringBuilder()
        for (i in 0 until o)
            sb.append(i)
        // System.out.println(sb.toString());
        sbTime = System.currentTimeMillis() - start

    }
}