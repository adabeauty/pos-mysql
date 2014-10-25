package com.thoughtworks.mysql.ulti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ulti {

    private String driverName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/pos";   //pos是database名字
    private String user = "root";
    private String password = "wh0415";

    private Connection conn = null;
    public Connection getConnection(){

        try {
            Class.forName(driverName);       //加载JDBCdriver
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

   public void closeConnection(){
       try {
           conn.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }

}
