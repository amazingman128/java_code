package com.example.designpattern.single;

public class Singleton02 {
    private Singleton02() {
    }

    private static class SingletonInstance {
        private static final Singleton02 instance = new Singleton02();
    }

    public static Singleton02 getInstance() {
        return SingletonInstance.instance;
    }

    public static void main(String[] args) {

    }
}
