package com.example.demo.demo

import com.sun.org.apache.xpath.internal.operations.Bool

fun main() {
    var map = Array(8) { IntArray(7) }

    for (i in 0 until 7) {
        map[0][i] = 1
        map[7][i] = 1
    }

    for (i in 0 until 8) {
        map[i][0] = 1
        map[i][6] = 1
    }
    map[3][1] = 1
    map[3][2] = 1

    printMap(map)

    stepWay(map, 1, 1)
    println("**********************")
    printMap(map)

}

fun printMap(map: Array<IntArray>) {
    for (i in 0 until 8) {
        for (j in 0 until 7) {
            print(map[i][j].toString() + " ")
        }
        println()
    }
}

fun stepWay(map: Array<IntArray>, x: Int, y: Int): Boolean {
    if (map[6][5] == 2) {
        return true;
    } else {
        if (map[x][y] == 0) {
            map[x][y] = 2
            if (stepWay(map, x + 1, y)) {
                return true
            } else if (stepWay(map, x, y + 1)) {
                return true
            } else if (stepWay(map, x - 1, y)) {
                return true
            } else if (stepWay(map, x, y - 1)) {
                return true
            } else {
                map[x][y] = 3
                return false
            }
        } else {
            return false
        }
    }
}

