package com.example.demo.sort.select

fun main() {
    var length: Int = 10;
    var source = IntArray(length);
    for (index in 0 until length) {
        source[index] = random(length)
    }
    println("source ")
    for (index in 0 until length) {
        print(source[index].toString() + " ")
    }

    for (i in 0 until length) {
        var index = i
        var tmp = source[i]
        for (j in i until length) {
            if (source[j] <= tmp) {
                tmp = source[j]
                index = j
            }
        }
        source[index] = source[i]
        source[i] = tmp
    }

    println("after change ")
    for (index in 0 until length) {
        print(source[index].toString() + " ")
    }
}

fun random(max: Int): Int {
    return (Math.random() * max).toInt()
}