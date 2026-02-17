package org.example.dao;

import org.example.entity.Person;
import org.example.jdbcDemo.DatabaseConnection;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDaoImpl implements PersonDao{
    @Override
    public List<Person> findAll() {
        List<Person> pList=new ArrayList<>();

        Connection con=DatabaseConnection.getConnection();
        String sql="select * from praveen";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                Person p=mapToPerson(rs);
                pList.add(p);
            }

        }
        catch(SQLException e)
        {
            throw  new RuntimeException(e);
        }
        return pList;
    }
     private Person mapToPerson(ResultSet rs) throws SQLException
     {
         int id=rs.getInt("id");
         String fname=rs.getString("fname");
         String lname=rs.getString("lname");
         return new Person(id,fname,lname);
     }

    @Override
    public void addPerson(Person p) {
        Connection con=DatabaseConnection.getConnection();
        String sql="insert into praveen(fname,lname) values(?,?)";
        try{
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1,p.getFname());
            ps.setString(2,p.getLname());
            int rowseffected=ps.executeUpdate();
            System.out.println("rows effected:"+rowseffected);

        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void deleteById(int pid) {
        String sql="delete from praveen where id=?";
        try(Connection con=DatabaseConnection.getConnection())
        {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,pid);

            int effected=ps.executeUpdate();
            System.out.println("Rows Effected:"+effected);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Person findById(int id) {
        String sql="Select * from praveen where id=?";
        try(Connection con=DatabaseConnection.getConnection())
        {   PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                return mapToPerson(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return null;
    }

    @Override
    public List<Person> findByFnameContaining(String n) {
        List<Person>personList=new ArrayList<>();
        String sql="select * from praveen where fname like ?";
        try(Connection con=DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,"%"+n+"%");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                personList.add(mapToPerson(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personList;
    }

    @Override
    public List<Person> findSortedByFname() {
        List<Person>personList=new ArrayList<>();
        String sql="Select * from praveen order by fname";
        try(Connection con=DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next())
            {
                personList.add(mapToPerson(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personList;
    }

    @Override
    public boolean existId(int id) {
        String sql="select * from praveen where id=?";
        try(Connection con=DatabaseConnection.getConnection()) {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;

    }
}
