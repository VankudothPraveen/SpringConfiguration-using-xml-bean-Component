package org.example.Service;

import org.example.dao.ProductDao;
import org.example.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductServiceImpl implements ProductService{
    ProductDao productDao;

    public ProductServiceImpl(ProductDao dao) {
        this.productDao = dao;
    }

    @Override
    public void addProduct(Product product) {
        if(product==null||product.getProductname()==null||product.getProductname().trim().isEmpty()||product.getCost()<0||product.getDiscountpercentage()<0)
        {
            System.out.println("invalid data cant be add into database");
            return;
        }
        productDao.addProduct(product);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public List<Product> sortByCostAscending() {
        return productDao.sortByCostAscending();
    }

    @Override
    public List<Product> sortByCostDescending() {
        return productDao.sortByCostDescending();
    }

    @Override
    public List<Product> sortByDiscountAscending() {
        return productDao.sortByDiscountAscending();
    }

    @Override
    public List<Product> sortByDiscountDescending() {
        return productDao.sortByDiscountDescending();
    }

    @Override
    public List<Product> sortByRating() {
        return productDao.sortByRating();
    }

    @Override
    public List<Product> filterByName(String name) {
        if(name==null||name.trim().isEmpty())
        {
            System.out.println("invalid product name");
            return List.of();
        }
        List<Product> result = productDao.filterByName(name);
        if(result.isEmpty())
        {
            System.out.println("No products found with this name");
        }
        return result;
    }

    @Override
    public List<Product> filterByBrand(String brand) {
        if(brand==null||brand.trim().isEmpty())
        {
            System.out.println("invalid brand name");
            return List.of();
        }
        List<Product> result = productDao.filterByBrand(brand);
        if(result.isEmpty())
        {
            System.out.println("No products found with this brand");
        }
        return result;
    }

    @Override
    public List<Product> filterByCategory(String category) {
        if(category==null||category.trim().isEmpty())
        {
            System.out.println("invalid category");
            return List.of();
        }
        List<Product> result = productDao.filterByCategory(category);
        if(result.isEmpty())
        {
            System.out.println("No products found in this category");
        }
        return result;
    }

    @Override
    public List<Product> filterByMinCost(double minCost) {
        if(minCost<0)
        {
            System.out.println("enter >0");
            return List.of();
        }
        return productDao.filterByMinCost(minCost);
    }

    @Override
    public List<Product> filterByMaxCost(double maxCost) {
        if(maxCost<0)
        {
            System.out.println("maxcost >0");
            return List.of();
        }
        return productDao.filterByMaxCost(maxCost);
    }

    @Override
    public boolean existid(int id) {
        if(id<=0)
        {
            System.out.println("invalid id provided");
            return false;
        }
        return productDao.existid(id);
    }
}
