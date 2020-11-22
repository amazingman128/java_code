package com.example.demo.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleteAbleFutureDemo {
    public static void main(final String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 1024;
        });
        try {
            int a = future.whenComplete((t, u) -> {
                System.out.println(t);
                System.out.println(u);
            }).exceptionally(f -> {
                // 10/0;
                return 0000;
            }).get();
            System.out.println(a);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
