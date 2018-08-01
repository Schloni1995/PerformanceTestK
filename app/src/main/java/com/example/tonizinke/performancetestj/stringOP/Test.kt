package com.example.tonizinke.performancetestj.stringOP

class Test @Throws(InterruptedException::class)
constructor() {
    var o = 10000

    init {
        val cs = ConcatString(o)
        val bs = BuildString(o)
        val concat = Thread(cs)
        val build = Thread(bs)
        concat.start()
        build.start()

        // while (!concat.isInterrupted() || !build.isInterrupted())
        // Thread.sleep(1000);
        while (concat.isAlive || build.isAlive)
            Thread.sleep(1000)

        println("Concattime = " + cs.conTime * MILLI + " s")
        println("Buildingtime = " + bs.sbTime * MILLI + " s")
    }

    companion object {
        val MILLI = Math.pow(10.0, -3.0)
    }
}
