package com.example.designpattern.prototype.deepcopy;

import java.io.Serializable;

public class Phone implements Serializable, Cloneable, DeepClone {

    private String phoneNumber;
    private String brand;


    public Phone() {
    }

    public Phone(String phoneNumber, String brand) {
        this.phoneNumber = phoneNumber;
        this.brand = brand;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return deepCopy();
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
