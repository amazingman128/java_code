package com.example.designpattern.prototype.deepcopy;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable, Cloneable, DeepClone {
    private String username;

    private int age;

    private Phone phone;

    public User() {
    }

    public User(String username, int age, Phone phone) {
        this.username = username;
        this.age = age;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return deepCopy();
//        return super.clone();
    }
}
