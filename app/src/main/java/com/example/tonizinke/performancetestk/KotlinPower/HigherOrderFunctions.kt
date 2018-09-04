package com.example.tonizinke.performancetestk.KotlinPower

class Car(id:Int)
{
}

fun block()
{
    for (i in 0..100000) {
        println("Car: ${Car(i)}")
    }
}

fun benchmark(block: () -> Unit): Long
{
    val startTime = System.currentTimeMillis()
    block.invoke()
    return System.currentTimeMillis() - startTime
}

fun test()
{
    val runtime = benchmark {
        block()
    }
    println("Executed in ${runtime}ms")
}
