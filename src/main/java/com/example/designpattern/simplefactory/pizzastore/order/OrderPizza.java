package com.example.designpattern.simplefactory.pizzastore.order;

import com.example.designpattern.simplefactory.pizzastore.pizza.GeekPizza;
import com.example.designpattern.simplefactory.pizzastore.pizza.GreenPizza;
import com.example.designpattern.simplefactory.pizzastore.pizza.Pizza;
import com.example.designpattern.simplefactory.pizzastore.pizza.PizzaSimpleFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OrderPizza {

    public OrderPizza() throws IOException {
        do {
            String type = getPizzaType();
            Pizza pizza = PizzaSimpleFactory.getPizza(type);
            if (null != pizza) {
                pizza.make();
                pizza.fake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println(type + " 类型Pizza不存在");
            }
        } while (true);
    }

    public String getPizzaType() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入Pizza类型?");
        String str = bufferedReader.readLine();
        return str;
    }
}
