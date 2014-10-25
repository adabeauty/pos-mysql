package com.thoughtworks.mysql.DAO;

import com.thoughtworks.mysql.VO.Item;
import com.thoughtworks.mysql.ulti.Ulti;

import java.sql.*;

public class ItemDao {
    private Statement stmt = null;
    private ResultSet rs = null;
    private Ulti ulti= new Ulti();

    public void insertItem(Item item){
        String sql = "insert into items values('"+ item.getBarcode() +"', '"+ item.getName()+"', '" + item.getUnit() +"', '"+item.getPrice()+"')";

        Connection conn = null;
        conn = ulti.getConnection();
        try{
            stmt = conn.createStatement();
            //DML(数据操纵语言insert,)
            int result = stmt.executeUpdate(sql);

            ulti.closeConnection();
            stmt.close();

            if(result > 0){
                System.out.println("插入成功");
            }else{
                System.out.println("插入失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteItem(String barcode){
        String sql = "DELETE FROM items where barcode = '" +barcode +"' ";

        Connection conn = null;
        conn = ulti.getConnection();
        try{
            stmt = conn.createStatement();
            //DML(数据操纵语言insert,)
            int result = stmt.executeUpdate(sql);

            ulti.closeConnection();
            stmt.close();

            if(result > 0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateItem(String barcode){

        String sql = "UPDATE items SET name = 'cocacola', unit = 'can', price = 3.5 where barcode = '" + barcode +"' ";

        Connection conn = null;
        conn = ulti.getConnection();
        try{
            stmt = conn.createStatement();
            //DML(数据操纵语言insert,)
            int result = stmt.executeUpdate(sql);

            conn.close();
            stmt.close();

            if(result > 0){
                System.out.println("更新成功");
            }else{
                System.out.println("更新失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
