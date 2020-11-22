package com.example.designpattern.simplefactory.pizzastore.pizza;

public class PizzaSimpleFactory {
    public static Pizza getPizza(String type) {
        Pizza pizza = null;
        switch (type) {
            case "geek":
                pizza = new GeekPizza();
                pizza.setName("GEEK");
                break;
            case "green":
                pizza = new GreenPizza();
                pizza.setName("GREEN");
                break;
            default:
                break;
        }
        return pizza;
    }
}
