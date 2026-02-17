package org.example.Service;

import org.example.dao.PersonDao;
import org.example.entity.Person;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PersonServiceImpl implements PersonService {
    PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Override
    public void addPerson(Person p) {
        if(p==null||p.getFname()==null||p.getFname().trim().isEmpty()||p.getLname()==null||p.getLname().trim().isEmpty())
        {
            System.out.println("invalid person details");
            return;
        }
        personDao.addPerson(p);
    }

    @Override
    public void deleteById(int id) {
        if(id<=0)
        {
            System.out.println("invalid id provided by user");
            return;
        }
        if(!personDao.existId(id))
        {
            System.out.println("No person exists with this id");
            return;
        }
        personDao.deleteById(id);
        System.out.println("Person deleted successfully");
    }

    @Override
    public Person findById(int id) {
        if(id<=0)
        {
            System.out.println("enter valid person id");
            return null;
        }
        Person px=personDao.findById(id);
        if(px==null)
        {
            System.out.println("enter id doest have data in database");
        }
        return px;
    }

    @Override
    public List<Person> findByFnameContaining(String n) {
        if(n==null||n.trim().isEmpty())
        {
            System.out.println("invalid search string");
            return List.of();
        }
        return personDao.findByFnameContaining(n);
    }

    @Override
    public List<Person> findSortedByFname() {
        return personDao.findSortedByFname();
    }

    @Override
    public boolean existId(int id) {
        if(id<=0)
        {
            System.out.println("invalid id provided");
            return false;
        }
        return personDao.existId(id);
    }
}
