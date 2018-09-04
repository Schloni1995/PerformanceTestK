package com.example.tonizinke.performancetestk

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.tonizinke.performancetestk.maths.Fibonacci
import com.example.tonizinke.performancetestk.maths.Leibnitzreihe
import com.example.tonizinke.performancetestk.prime.Eratosthenes
import com.example.tonizinke.performancetestk.sorts.BubbleSort
import com.example.tonizinke.performancetestk.sorts.InsertionSort
import com.example.tonizinke.performancetestk.sorts.Mergesort
import com.example.tonizinke.performancetestk.stringOP.BuildString
import com.example.tonizinke.performancetestk.stringOP.ConcatString

class MainActivity : AppCompatActivity() {
    val start: Long = System.currentTimeMillis()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fibButton: Button = findViewById(R.id.btn_fibonacci)
        val leibnitzButton: Button = findViewById(R.id.btn_leipnitz)
        val eratoButton: Button = findViewById(R.id.btn_eratosthenes)
        val concatButton: Button = findViewById(R.id.btn_concat)
        val buildButton: Button = findViewById(R.id.btn_build)
        val bubbleButton: Button = findViewById(R.id.btn_bubblesort)
        val insButton: Button = findViewById(R.id.btn_insertionsort)
        val merButton: Button = findViewById(R.id.btn_mergesort)

        fibButton.setOnClickListener {
            val fib = Fibonacci(40)
            toOutput(fib.timeDiff.toString())
        }
        eratoButton.setOnClickListener {
            val er = Eratosthenes(1000)
            toOutput(er.timeDiff.toString())
        }
        leibnitzButton.setOnClickListener {
            val lr = Leibnitzreihe()
            toOutput(lr.timeDiff().toString())
        }
        buildButton.setOnClickListener {
            val bs = BuildString(50000)
            toOutput(bs.sbTime.toString())
        }
        concatButton.setOnClickListener {
            val cs = ConcatString(10000)
            toOutput(cs.conTime.toString())
        }
        bubbleButton.setOnClickListener {
            val bs = BubbleSort()
            toOutput(bs.timeDiff.toString())
        }
        insButton.setOnClickListener {
            val `is` = InsertionSort()
            toOutput(`is`.timeDiff.toString())
        }
        merButton.setOnClickListener {
            val ms = Mergesort()
            toOutput(ms.timeDiff.toString())
        }

        Toast.makeText(this@MainActivity, (System.currentTimeMillis() - start).toString() + "", Toast.LENGTH_LONG).show()
    }

    private fun toOutput(msg: String) {
        Log.i(MainActivity::class.java.simpleName, msg)
        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
    }
}
