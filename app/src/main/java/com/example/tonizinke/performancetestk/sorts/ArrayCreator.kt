package com.example.tonizinke.performancetestk.sorts

class ArrayCreator(min: Int, max: Int) {
    val randomArray: IntArray = IntArray(5000)
    init {
        for (i in randomArray.indices)
            randomArray[i] = (Math.random() * max).toInt() + min
    }
}
