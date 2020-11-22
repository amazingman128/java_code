package com.example.demo.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket02 {
    private int number = 30;

    private final Lock lock = new ReentrantLock();

    public void saleTicket() {
        lock.lock();
        try {
            if (number > 0) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " 售出" + number-- + "，剩余" + number);
            }
        } finally {
            lock.unlock();
        }

    }
}

public class SaleTickDemo2 {


    public static void main(String[] args) {
        Ticket02 ticket02 = new Ticket02();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket02.saleTicket();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket02.saleTicket();
                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket02.saleTicket();
                }
            }
        }, "C").start();
    }
}
