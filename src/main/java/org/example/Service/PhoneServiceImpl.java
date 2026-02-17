package org.example.Service;

import org.example.dao.PhoneDao;
import org.example.dao.PhoneDaoImpl;
import org.example.entity.Phone;
import org.example.jdbcDemo.DatabaseConnection;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class PhoneServiceImpl implements PhoneService{
    PhoneDao phoneDao;

    public PhoneServiceImpl(@Qualifier("phoneDaoImpl") PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }

    @Override
    public void addPhone(Phone phone) {
        if(phone==null|| phone.getBrand()==null|| phone.getBrand().trim().isEmpty()|| phone.getName()==null||phone.getName().trim().isEmpty()||phone.getPrice()<0||phone.getCamerapx()<0)
        {
            System.out.println("cannot add invalid data to database");
            return;
        }
        phoneDao.addPhone(phone);
    }

    @Override
    public List<Phone> findAll() {
        return phoneDao.findAll();
    }

    @Override
    public List<Phone> sortByPriceAsc() {
        return phoneDao.sortByPriceAsc();
    }

    @Override
    public List<Phone> sortByPriceDesc() {
        return phoneDao.sortByPriceDesc();
    }

    @Override
    public List<Phone> filterByBrand(String brand) {
        if(brand==null||brand.trim().isEmpty())
        {
            System.out.println("invalid brand name");
            return List.of();
        }
        return phoneDao.filterByBrand(brand);
    }

    @Override
    public List<Phone> filterByMinPrice(double minPrice) {
        if(minPrice<0)
        {
            System.out.println("price cannot be negative");
            return List.of();
        }
        return phoneDao.filterByMinPrice(minPrice);
    }

    @Override
    public List<Phone> filterByMaxPrice(double maxPrice) {
        if(maxPrice<0)
        {
            System.out.println("price cannot be negative");
            return List.of();
        }
        return phoneDao.filterByMaxPrice(maxPrice);
    }

    @Override
    public List<Phone> sortByCamerapx() {
        return phoneDao.sortByCamerapx();
    }

    @Override
    public Phone findPhoneById(int id) {
       if(id<=0)
       {
           System.out.println("Invalid id provided");
           return null;
       }
       Phone p=phoneDao.findPhoneById(id);
       if(p==null)
       {
           System.out.println("No phone exists with this id");
       }

        return p;


    }
}
