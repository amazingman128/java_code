package com.example.demo.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLockDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 离开了教师");
                countDownLatch.countDown();
            }, "" + i).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t 关门走人");

    }
}
