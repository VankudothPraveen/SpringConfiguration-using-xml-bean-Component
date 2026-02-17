package org.example.dao;

import org.example.entity.Product;
import org.example.jdbcDemo.DatabaseConnection;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class ProductDaoimpl implements ProductDao{
    @Override
    public void addProduct(Product product) {
        String sql = "insert into product(productname,cost,brand,category,rating,discountpercentage) values(?,?,?,?,?,?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, product.getProductname());
            ps.setDouble(2, product.getCost());
            ps.setString(3, product.getBrand());
            ps.setString(4, product.getCategory());
            ps.setInt(5, product.getRating());
            ps.setInt(6, product.getDiscountpercentage());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Product> findAll() {
        List<Product>productlist=new ArrayList<>();
        String sql="Select * from product";
        try(Connection con= DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                productlist.add(mapToProduct(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productlist;
    }

    private Product mapToProduct(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("productname");
        double cost = rs.getDouble("cost");
        String brand = rs.getString("brand");
        String category = rs.getString("category");
        int rating = rs.getInt("rating");
        int discount = rs.getInt("discountpercentage");

        return new Product(id, name, cost, brand, category, rating, discount);

    }

    @Override
    public List<Product> sortByCostAscending() {

        List<Product> list = new ArrayList<>();
        String sql = "select * from product order by cost asc";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapToProduct(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public List<Product> sortByCostDescending() {
        List<Product>list=new ArrayList<>();
        String sql="Select * from product order by cost desc";
        try(Connection con=DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                list.add(mapToProduct(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;

    }

    @Override
    public List<Product> sortByDiscountAscending() {
        List<Product>list=new ArrayList<>();
        String sql="Select * from product order by discountpercentage ";
        try(Connection con=DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                list.add(mapToProduct(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;

    }

    @Override
    public List<Product> sortByDiscountDescending() {
        List<Product>list=new ArrayList<>();
        String sql="Select * from product order by discountpercentage desc ";
        try(Connection con=DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                list.add(mapToProduct(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;

    }

    @Override
    public List<Product> sortByRating() {
        List<Product>list=new ArrayList<>();
        String sql="Select * from product order by rating ";
        try(Connection con=DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                list.add(mapToProduct(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Product> filterByName(String name) {
        List<Product>list=new ArrayList<>();
        String sql="select * from product where productname LIKE ?";
        try(Connection con=DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                list.add(mapToProduct(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Product> filterByBrand(String brand) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from product where brand=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, brand);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapToProduct(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public List<Product> filterByCategory(String category) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from product where category=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, category);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapToProduct(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public List<Product> filterByMinCost(double minCost) {
        List<Product>list=new ArrayList<>();
        String sql="select * from product where cost>?";
        try(Connection con=DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1,minCost);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                list.add(mapToProduct(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Product> filterByMaxCost(double maxCost) {
        List<Product>list=new ArrayList<>();
        String sql="select * from product where cost<?";
        try(Connection con=DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1,maxCost);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                list.add(mapToProduct(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;

    }

    @Override
    public boolean existid(int id) {
        String sql="select * from product where id=?";
        try(Connection con=DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next())return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
