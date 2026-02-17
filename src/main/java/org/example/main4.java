package org.example;

import org.example.jdbcDemo.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main4 {
    public static void main(String[] args) {
        try (Connection con=DatabaseConnection.getConnection()) {
            String sql="select * from praveen";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                int id=rs.getInt(1);
                String fname=rs.getString(2);
                String lname=rs.getString(3);
                System.out.println("id:"+id+", name:"+fname+", lname:"+lname);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
