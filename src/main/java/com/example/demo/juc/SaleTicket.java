package com.example.demo.juc;

class Ticket {
    private Integer number = 30;

    public synchronized void saleTicket() {
        if (number>0){
            String name = Thread.currentThread().getName();
            System.out.println(name + " 售出" + number-- + "，剩余" + number);
        }

    }
}


public class SaleTicket {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.saleTicket();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.saleTicket();
                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.saleTicket();
                }
            }
        }, "C").start();
    }
}
