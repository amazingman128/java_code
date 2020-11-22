package com.example.demo.sort;

public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] source = {-1, 9, -3, 6, 5,-100};
        int length = source.length;
        int tmp = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (source[j + 1] < source[j]) {
                    tmp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.print(source[i] + " ");
        }
    }
}
