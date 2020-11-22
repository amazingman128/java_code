package com.example.designpattern.simplefactory.pizzastore.pizza;

public abstract class Pizza {


    public String name;


    public void make() {
        System.out.println(name + " 正在制作");
    }

    public void fake() {
        System.out.println(name + " 正在烤制");
    }

    public void cut() {
        System.out.println(name + " 正在切片");
    }

    public void box() {
        System.out.println(name + " 正在打包");
    }


    public void setName(String name) {
        this.name = name;
    }
}
