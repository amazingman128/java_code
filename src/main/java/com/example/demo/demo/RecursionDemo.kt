package com.example.demo.demo

fun main() {
    test(5)
}

fun test(a: Int) {
    if (a > 2) {
        test(a - 1)
    }
    println("a = $a")
}