package com.example.demo.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CircleBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("龙珠集合完毕，召唤神龙");
        });

        for (int i = 1; i <= 7; i++) {
            final int tmp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 收集到第" + tmp + "颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }

}
