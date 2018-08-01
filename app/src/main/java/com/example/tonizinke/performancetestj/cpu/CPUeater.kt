package com.example.tonizinke.performancetestj.cpu

import java.util.*
import java.util.concurrent.atomic.LongAdder

class CPUeater @Throws(InterruptedException::class)
constructor(numThreads: Int) {

    init {
        if (numThreads < 1) {
            System.err.println("Number of threads should be at least 1")
            System.exit(1)
        }

        val counter = LongAdder()

        val runningCalcs = ArrayList<CalculationThread>()
        val runningThreads = ArrayList<Thread>()

        System.out.printf("Starting %d threads\n", numThreads)

        for (i in 0 until numThreads) {
            val r = CalculationThread(counter)
            val t = Thread(r)
            runningCalcs.add(r)
            runningThreads.add(t)
            t.start()
        }

        for (i in 0..14) {
            counter.reset()
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                break
            }

            System.out.printf("[%d] Calculations per second: %d (%.2f per thread)\n", i, counter.toLong(),
                    counter.toLong().toDouble() / numThreads)
        }

        for (i in runningCalcs.indices) {
            runningCalcs[i].stop()
            runningThreads[i].join()
        }
    }

    class CalculationThread(private val calculationsPerformed: LongAdder) : Runnable {
        private val rng: Random
        private var stopped: Boolean = false

        init {
            stopped = false
            rng = Random()
        }

        fun stop() {
            stopped = true
        }

        override fun run() {
            while (!stopped) {
                val r = rng.nextFloat().toDouble()
                val v = Math.sin(Math.cos(Math.sin(Math.cos(r))))
                calculationsPerformed.add(1)
            }
        }
    }
}
