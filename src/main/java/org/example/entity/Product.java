package org.example.entity;

public class Product {
    private int id;
    private String productname;
    private Double cost;
    private String brand;
    private String category;
    private int rating;
    private int discountpercentage;
    public Product(int id,String p,Double c,String b,String cat,int r,int d)
    {   this.id=id;
        this.productname=p;
        this.cost=c;
        this.brand=b;
        this.category=cat;
        this.rating=r;
        this.discountpercentage=d;
    }

    public Product(String productname, Double cost, String brand, String category, int rating, int discountpercentage) {
        this.productname = productname;
        this.cost = cost;
        this.brand = brand;
        this.category = category;
        this.rating = rating;
        this.discountpercentage = discountpercentage;
    }

    public Product() {
    }

    public Product(String productname) {
        this.productname = productname;
    }

    public int getId() {
        return id;
    }

    public String getProductname() {
        return productname;
    }

    public Double getCost() {
        return cost;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public int getRating() {
        return rating;
    }

    public int getDiscountpercentage() {
        return discountpercentage;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", productname='" + productname + '\'' +
                ", cost=" + cost +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                ", discountpercentage=" + discountpercentage +
                '}';
    }
}

