package org.example.dao;

import org.example.entity.Phone;
import org.example.jdbcDemo.DatabaseConnection;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
@Primary
public class PhoneDaoImpl implements PhoneDao{
    @Override
    public void addPhone(Phone p) {
        String sql="insert into phone(name,brand,price,camerapx) values(?,?,?,?)";
        try(Connection con= DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,p.getName());
            ps.setString(2,p.getBrand());
            ps.setDouble(3,p.getPrice());
            ps.setInt(4,p.getCamerapx());
            ps.executeUpdate();
            System.out.println("added successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Phone> findAll() {
        List<Phone>list=new ArrayList<>();
        String sql="select * from phone";
        try(Connection con=DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                list.add(mapToPhone(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private Phone mapToPhone(ResultSet rs) throws SQLException{
        int id=rs.getInt("id");
        String pname=rs.getString("name");
        String brand=rs.getString("brand");
        Double price=rs.getDouble("price");
        int camerapx=rs.getInt("camerapx");
        return new Phone(id,pname,brand,price,camerapx);


    }

    @Override
    public List<Phone> sortByPriceAsc() {
        List<Phone>list=new ArrayList<>();
        String sql="select * from phone order by price";
        try(Connection con=DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                list.add(mapToPhone(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Phone> sortByPriceDesc() {
        List<Phone>list=new ArrayList<>();
        String sql="select * from phone order by price desc";
        try(Connection con=DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                list.add(mapToPhone(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;

    }

    @Override
    public List<Phone> filterByBrand(String brand) {
        List<Phone>list=new ArrayList<>();
        String sql="select * from phone where brand=?";
        try(Connection con=DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,brand);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                list.add(mapToPhone(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;


    }

    @Override
    public List<Phone> filterByMinPrice(double minPrice) {
        List<Phone>list=new ArrayList<>();
        String sql="select * from phone where price>?";
        try(Connection con=DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1,minPrice);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                list.add(mapToPhone(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Phone> filterByMaxPrice(double maxPrice) {
        List<Phone>list=new ArrayList<>();
        String sql="select * from phone where price<?";
        try(Connection con=DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1,maxPrice);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                list.add(mapToPhone(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Phone> sortByCamerapx() {
        String sql="select * from phone order by camerapx";
        List<Phone>list=new ArrayList<>();
        try(Connection con=DatabaseConnection.getConnection()) {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                list.add(mapToPhone(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Phone findPhoneById(int id) {

        String sql="Select * from phone where id=?";
        try(Connection con= DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                return mapToPhone(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
