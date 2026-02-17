package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/jdbc_demo";
        String username="root";
        String password="Praveen@12";
        Connection con=null;
        try{
            con= DriverManager.getConnection(url,username,password);
            String sql="Create table praveen(id int primary key Auto_Increment,fname varchar(20),lname varchar(20))";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.execute();
            System.out.println("table created successfully");
        } catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        }
    }
