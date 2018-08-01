package com.example.tonizinke.performancetestj.prime

import java.math.BigInteger

class MillerRabin {
    init {
        val n = BigInteger("64646612454013")
        val certainty = Integer.parseInt("100000")
        println(n.toString() + " is " + if (n.isProbablePrime(certainty)) "probably prime" else "composite")
    }

    companion object {

        // this is the RabinMiller test, deterministically correct for n <
        // 341,550,071,728,321
        // http://rosettacode.org/wiki/Miller-Rabin_primality_test#Python:_Proved_correct_up_to_large_N
        @JvmOverloads
        fun isPrime(n: BigInteger, precision: Int = 100): Boolean {

            if (n.compareTo(BigInteger("341550071728321")) >= 0)
                return n.isProbablePrime(precision)

            val intN = n.toInt()
            if (intN == 1 || intN == 4 || intN == 6 || intN == 8) return false
            if (intN == 2 || intN == 3 || intN == 5 || intN == 7) return true

            val primesToTest = getPrimesToTest(n)
            if (n == BigInteger("3215031751")) return false
            var d = n.subtract(BigInteger.ONE)
            var s = BigInteger.ZERO
            while (d.mod(BigInteger.valueOf(2)) == BigInteger.ZERO) {
                d = d.shiftRight(1)
                s = s.add(BigInteger.ONE)
            }
            for (a in primesToTest)
                if (try_composite(a, d, n, s)) return false
            return true
        }

        fun isPrime(n: Int): Boolean {
            return isPrime(BigInteger.valueOf(n.toLong()), 100)
        }

        fun isPrime(n: Long): Boolean {
            return isPrime(BigInteger.valueOf(n), 100)
        }

        private fun getPrimesToTest(n: BigInteger): IntArray {
            if (n.compareTo(BigInteger("3474749660383")) >= 0)
                return intArrayOf(2, 3, 5, 7, 11, 13, 17)
            if (n.compareTo(BigInteger("2152302898747")) >= 0) return intArrayOf(2, 3, 5, 7, 11, 13)
            if (n.compareTo(BigInteger("118670087467")) >= 0) return intArrayOf(2, 3, 5, 7, 11)
            if (n.compareTo(BigInteger("25326001")) >= 0) return intArrayOf(2, 3, 5, 7)
            return if (n.compareTo(BigInteger("1373653")) >= 0) intArrayOf(2, 3, 5) else intArrayOf(2, 3)
        }

        private fun try_composite(a: Int, d: BigInteger, n: BigInteger, s: BigInteger): Boolean {
            val aB = BigInteger.valueOf(a.toLong())
            if (aB.modPow(d, n) == BigInteger.ONE) return false
            var i = 0
            while (BigInteger.valueOf(i.toLong()).compareTo(s) < 0) {
                // if pow(a, 2**i * d, n) == n-1
                if (aB.modPow(BigInteger.valueOf(2).pow(i).multiply(d), n) == n.subtract(BigInteger.ONE))
                    return false
                i++
            }
            return true
        }
    }
}