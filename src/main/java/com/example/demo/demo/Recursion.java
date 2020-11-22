package com.example.demo.demo;

public class Recursion {
    public static void main(String[] args) {
        test(5);
    }

    public static void test(int i) {
        if (i > 2) {
            test(i - 1);
        }
        System.out.println("i = " + i);
    }
}
