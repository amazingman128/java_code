package com.example.demo.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket03 {
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

public class SaleTicket03 {
    public static void main(String[] args) {

        Ticket03 ticket = new Ticket03();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        }, "C").start();
    }
}
