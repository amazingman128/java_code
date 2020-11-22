package com.example.demo.datastruct

fun main() {
    var a = IntArray(40)
    a[0] = 1
    a[1] = 1
    for (i in 2 until 40) {
        a[i] = a[i - 2] + a[i - 1]
    }
    for (tem in a) {
        print("$tem ")
    }
}