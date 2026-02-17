package org.example.dao;

import org.example.entity.Phone;
import java.util.List;

public interface PhoneDao {

    void addPhone(Phone phone);

    List<Phone> findAll();

    List<Phone> sortByPriceAsc();

    List<Phone> sortByPriceDesc();

    List<Phone> filterByBrand(String brand);

    List<Phone> filterByMinPrice(double minPrice);

    List<Phone> filterByMaxPrice(double maxPrice);
    List<Phone> sortByCamerapx();
    Phone findPhoneById(int id);

}
