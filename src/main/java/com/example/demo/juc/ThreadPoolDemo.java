package com.example.demo.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        // ExecutorService executor = Executors.newFixedThreadPool(2);
        // ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 1000; i++) {
                executor.execute(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            executor.shutdown();
        }
    }
}
