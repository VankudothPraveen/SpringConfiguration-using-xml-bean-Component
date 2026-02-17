package org.example;

import org.example.jdbcDemo.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class main2 {
    public static void main(String[] args) {
        Connection con= DatabaseConnection.getConnection();
        String sql="insert into praveen(fname,lname)values(?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,"saurav");
            ps.setString(2,"ganguly");
            int rEffected=ps.executeUpdate();
            System.out.println("Rows inserted"+rEffected);
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
