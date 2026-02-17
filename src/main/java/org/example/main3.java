package org.example;

import org.example.jdbcDemo.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class main3 {
    public static void main(String[] args) {
        Connection con= DatabaseConnection.getConnection();
        String sql="update praveen set fname='praveen' where id=2";
        String dele="delete from praveen where id=1";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            int x=ps.executeUpdate();
            System.out.println("rows effected:"+x);
            PreparedStatement p=con.prepareStatement(dele);
            int y=p.executeUpdate();
            System.out.println("rowseffected by deletion:"+y);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
