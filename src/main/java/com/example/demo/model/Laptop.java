package com.example.demo.model;

public class Laptop {
    private String make;
    private double price;

    public Laptop() {
    }

    public Laptop(String make, double price) {
        this.make = make;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "make='" + make + '\'' +
                ", price=" + price +
                '}';
    }
}
