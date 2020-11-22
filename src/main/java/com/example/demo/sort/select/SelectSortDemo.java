package com.example.demo.sort.select;

import java.time.LocalDateTime;
import java.util.Random;

public class SelectSortDemo {
    public static void main(String[] args) {
        int max = 80000;
        int[] source = new int[max];
        for (int i = 0; i < max; i++) {
            source[i] = (int) (Math.random() * max);
        }
        System.out.println(LocalDateTime.now());
        System.out.println("source");
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + " ");
        }

        for (int i = 0; i < source.length - 1; i++) {
            int tmp = source[i];
            int index = i;
            for (int k = i; k < source.length; k++) {
                if (tmp > source[k]) {
                    index = k;
                    tmp = source[k];
                }
            }
            source[index] = source[i];
            source[i] = tmp;
        }
        System.out.println("");
        System.out.println(LocalDateTime.now());
        System.out.println("after change");
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + " ");
        }
    }
}
