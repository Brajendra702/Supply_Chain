package com.example.anything;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
    String SQLURL="jdbc:mysql://localhost:3306/supply?useSSL=false";
    String userName="root";
    String password="Umath@123";
    Connection con=null;
    DatabaseConnection(){
        try{
            con= DriverManager.getConnection(SQLURL,userName,password);
            if(con!=null){
                System.out.println("DataBase is Connected");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    //Function To Execute Query
    public ResultSet executeQuery(String query){
        ResultSet res = null;
        try {
            Statement statement = con.createStatement();
            res = statement.executeQuery(query);
            return res;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }
    //Function to Execute DML command
    public int executeUpdate(String query)
    {
        int res = 0;
        try {
            Statement statement = con.createStatement();
            res = statement.executeUpdate(query);
            return res;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }

}
