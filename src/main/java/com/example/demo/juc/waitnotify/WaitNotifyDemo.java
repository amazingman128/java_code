package com.example.demo.juc.waitnotify;

class MyResource {
    public int getNumber() {
        return number;
    }

    private int number = 0;

    synchronized public void increment() throws InterruptedException {
        while (number != 0) {
            this.wait();
        }
        number++;
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " 增加了1" + "   最后" + number);
        this.notifyAll();
    }

    synchronized public void decrement() throws InterruptedException {
        while (number == 0) {
            this.wait();
        }
        number--;
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " 减少了1" + "   最后" + number);
        notify();
    }
}

public class WaitNotifyDemo {
    public static void main(String[] args) {
        MyResource resource = new MyResource();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    resource.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    resource.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    resource.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    resource.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}
