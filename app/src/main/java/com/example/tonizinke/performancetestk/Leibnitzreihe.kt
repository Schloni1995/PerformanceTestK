package com.example.tonizinke.performancetestk

class Leibnitzreihe
{
    var start: Long
    var end: Long

    init {
        start = System.nanoTime()
        leibnitz1()
        end = System.nanoTime()

//        start = System.currentTimeMillis()
//        leibnitz2()
//        end = System.currentTimeMillis()

    }


        private var loopMax: Long = 10000000
        private fun leibnitz1() {
            var zahl = 0.0
            var x = 1.0
            var b = false

            var i = 1
            while (i <= loopMax) {
                if (!b) {
                    zahl = +(1 / x)
                    b = true
                    // System.out.println("zahl + (1/" + x + ")" + " PI=zahl*4 == "
                    // + zahl * 4);
                } else {
                    zahl = -(1 / x)
                    b = false
                    // System.out.println("zahl - (1/" + x + ")" + " PI=zahl*4 == "
                    // + zahl * 4);

                }
                i++
                x = (+2).toDouble()
            }
//            println("Pi ist ungefaehr " + 4.0 * zahl)
        }

        private fun leibnitz2() {
            /*
         * Die unendliche (Leibnitz-)Reihe 1 - 1/3 + 1/5 - 1/7 + 1/9 - ... hat
         * den Wert Pi/4. Schreiben Sie ein Programm, das f�r ein festes n mit
         * Hilfe der Formel einen N�herungswert f�r Pi berechnet.
         */

            // uebrigens: der Mann hiess Leibniz und nicht, wie der Keks, Leibnitz

            val n = loopMax
            var pi4tel = 0.0

            // fuer jedes i von 1 bis n bilde 1.0 / (2 * i - 1) und addiere
            // bzw. subtrahiere, je nachdem ob i ungerade oder gerade ist
            for (i in 1..n)
                if (i % 2 == 1.toLong())
                    pi4tel += 1.0 / (2 * i - 1)
                else
                    pi4tel -= 1.0 / (2 * i - 1)

            // die Reihe ergibt Pi/4 nicht Pi!
//            println("Pi ist ungefaehr " + 4.0 * pi4tel)
    }

    fun timeDiff(): Long = end - start
}
