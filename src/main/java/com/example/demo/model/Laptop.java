package com.example.demo.model;

public class Laptop {
    private String make;
    private double price;
    private int id;
    public Laptop() {
    }

    public Laptop(String make, double price, int id) {
        this.make = make;
        this.price = price;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "make='" + make + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
