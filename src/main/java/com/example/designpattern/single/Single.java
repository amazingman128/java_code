package com.example.designpattern.single;

public class Single {
    public static volatile Single single;

    private Single() {

    }

    public synchronized static Single getInstance() {
        if (single == null) {
            synchronized (Single.class) {
                if (single == null) {
                    single = new Single();
                }
            }
        }
        return single;
    }

    public static void main(String[] args) {
        Single single1 = Single.getInstance();
        Single single2 = Single.getInstance();
        System.out.println(single1);
        System.out.println(single2);
    }
}


