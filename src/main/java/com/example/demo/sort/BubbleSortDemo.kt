package com.example.demo.sort

fun main() {
    var source = arrayOf(-1, -9, 3, 8, -100,-1500)
    var length = source.size
    var tmp = 0
    for (i in 0 until length - 1) {
        for (j in 0 until length - 1 - i) {
            if (source[j + 1] < source[j]) {
                tmp = source[j]
                source[j] = source[j + 1]
                source[j + 1] = tmp
            }
        }
    }
    for (i in 0 until length) {
        print(source[i].toString() + " ")
    }
}