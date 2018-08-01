package com.example.tonizinke.performancetestj

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.tonizinke.performancetestj.cpu.CPUeater
import com.example.tonizinke.performancetestj.prime.Eratosthenes
import com.example.tonizinke.performancetestj.prime.MillerRabin
import com.example.tonizinke.performancetestj.stringOP.BuildString
import com.example.tonizinke.performancetestj.stringOP.ConcatString

class MainActivity : AppCompatActivity() {
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
            Log.i(MainActivity::class.java.simpleName, "Finished")
            Toast.makeText(this@MainActivity, "Finished", Toast.LENGTH_SHORT).show()
        }
        cpuButton.setOnClickListener {
            try {
                CPUeater(2)
            } catch (e: InterruptedException) {
                Log.e("ERROR", e.message)
            }

            Log.i(MainActivity::class.java.simpleName, "Finished")
            Toast.makeText(this@MainActivity, "Finished", Toast.LENGTH_SHORT).show()
        }
        eratoButton.setOnClickListener {
            Eratosthenes()
            Log.i(MainActivity::class.java.simpleName, "Finished")
            Toast.makeText(this@MainActivity, "Finished", Toast.LENGTH_SHORT).show()
        }
        leibnitzButton.setOnClickListener {
            Leibnitzreihe()
            Log.i(MainActivity::class.java.simpleName, "Finished")
            Toast.makeText(this@MainActivity, "Finished", Toast.LENGTH_SHORT).show()
        }
        millerButton.setOnClickListener {
            MillerRabin()
            Log.i(MainActivity::class.java.simpleName, "Finished")
            Toast.makeText(this@MainActivity, "Finished", Toast.LENGTH_SHORT).show()
        }
        buildButton.setOnClickListener {
            val bs = BuildString(100000)
            val build = Thread(bs)
            build.start()
            Log.i(MainActivity::class.java.simpleName, "Finished")
            Toast.makeText(this@MainActivity, "Finished", Toast.LENGTH_SHORT).show()
        }
        concatButton.setOnClickListener {
            val cs = ConcatString(100000)
            val concat = Thread(cs)
            concat.start()

            Log.i(MainActivity::class.java.simpleName, "Finished")
            Toast.makeText(this@MainActivity, "Finished", Toast.LENGTH_SHORT).show()
        }
    }
}
