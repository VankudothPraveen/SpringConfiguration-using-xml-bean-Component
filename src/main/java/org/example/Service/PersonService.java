package org.example.Service;

import org.example.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();
    void addPerson(Person p);
    void deleteById(int id);
    Person findById(int id);
    List<Person>findByFnameContaining(String n);
    List<Person>findSortedByFname();
    boolean existId(int id);
}
