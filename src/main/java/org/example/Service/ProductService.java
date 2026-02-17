package org.example.Service;

import org.example.entity.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);

    List<Product> findAll();

    List<Product> sortByCostAscending();

    List<Product> sortByCostDescending();

    List<Product> sortByDiscountAscending();

    List<Product> sortByDiscountDescending();

    List<Product> sortByRating();

    List<Product> filterByName(String name);

    List<Product> filterByBrand(String brand);

    List<Product> filterByCategory(String category);

    List<Product> filterByMinCost(double minCost);

    List<Product> filterByMaxCost(double maxCost);
    boolean existid(int id);
}
