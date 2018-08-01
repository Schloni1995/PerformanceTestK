package com.example.tonizinke.performancetestk

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.tonizinke.performancetestk.cpu.CPUeater
import com.example.tonizinke.performancetestk.prime.Eratosthenes
import com.example.tonizinke.performancetestk.prime.MillerRabin
import com.example.tonizinke.performancetestk.stringOP.BuildString
import com.example.tonizinke.performancetestk.stringOP.ConcatString

class MainActivity : AppCompatActivity() {
    val start: Long = System.currentTimeMillis()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ackButton: Button
        val cpuButton: Button
        val leibnitzButton: Button
        val eratoButton: Button
        val millerButton: Button
        val concatButton: Button
        val buildButton: Button

        ackButton = findViewById(R.id.btn_ackermann)
        cpuButton = findViewById(R.id.btn_cpueater)
        eratoButton = findViewById(R.id.btn_eratosthenes)
        leibnitzButton = findViewById(R.id.btn_leipnitz)
        millerButton = findViewById(R.id.btn_miller_rabin)
        concatButton = findViewById(R.id.btn_concat)
        buildButton = findViewById(R.id.btn_build)

        ackButton.setOnClickListener {
            Ackermann.ackITT(0, 0)
            toOutput("Finished")
        }
        cpuButton.setOnClickListener {
            try {
                CPUeater(2)
            } catch (e: InterruptedException) {
                Log.e("ERROR", e.message)
            }
            toOutput("Finished")
        }
        eratoButton.setOnClickListener {
            Eratosthenes()
            toOutput("Finished")
        }
        leibnitzButton.setOnClickListener {
            val lr = Leibnitzreihe()
            toOutput(lr.timeDiff().toString())
        }
        millerButton.setOnClickListener {
            MillerRabin()
            toOutput("Finished")
        }
        buildButton.setOnClickListener {
            val bs = BuildString(50000)
            val build = Thread(bs)
            build.start()
            while (build.isAlive)
            {

            }
            toOutput(bs.sbTime.toString())
        }
        concatButton.setOnClickListener {
            val cs = ConcatString(50000)
            val concat = Thread(cs)
            concat.start()
            while (concat.isAlive) {

            }
            toOutput(cs.conTime.toString())
        }
        Toast.makeText(this@MainActivity, (System.currentTimeMillis() - start).toString() + "", Toast.LENGTH_LONG).show()
    }

    private fun toOutput(msg: String) {
        Log.i(MainActivity::class.java.simpleName, msg)
        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
    }
}
