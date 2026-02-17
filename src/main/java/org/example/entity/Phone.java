

package org.example.entity;

public class Phone {

    private int id;
    private String name;
    private String brand;
    private double price;
    private int camerapx;


    public Phone(int id, String name, String brand, double price, int camerapx) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.camerapx = camerapx;
    }

    public Phone(String name, String brand, double price, int camerapx) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.camerapx = camerapx;
    }

    public Phone() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getCamerapx() {
        return camerapx;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", camerapx=" + camerapx +
                '}';
    }
}

