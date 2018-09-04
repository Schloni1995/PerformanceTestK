package com.example.tonizinke.performancetestk.KotlinPower

class A {
    inner class Inner
}
class B {
    inner class Inner
}

typealias AInner = A.Inner
typealias BInner = B.Inner
