package com.thoughtworks.mysql.Dao;

import com.thoughtworks.mysql.VO.Item;
import com.thoughtworks.mysql.ulti.Ulti;

import java.sql.*;
import java.util.ArrayList;

public class ItemDao implements ItemIDao {
    private Statement stmt = null;
    private ResultSet rs = null;
    private Ulti ulti= new Ulti();

    @Override
    public Item getItemByBarcode(String barcode){
        String sql = "SELECT * FROM items WHERE barcode = '"+ barcode +"'";

        Item item = null;
        Connection conn = ulti.getConnection();
        try{
            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);
            rs.next();
            item = new Item(rs.getInt("id"), rs.getString("barcode"), rs.getString("name"), rs.getString("unit"), rs.getDouble("price"));

            ulti.closeConnection();
            stmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void insertItem(Item item){
        String sql = "insert into items values(null, '"+ item.getBarcode() +"', '"+ item.getName()+"', '" + item.getUnit() +"', '"+item.getPrice()+"')";

        Connection conn = ulti.getConnection();
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

    @Override
    public void deleteItem(String barcode){
        String sql = "DELETE FROM items where barcode = '" +barcode +"' ";

        Connection conn = ulti.getConnection();
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
    @Override
    public void updateItem(String barcode){

        String sql = "UPDATE items SET name = 'cocacola', unit = 'can', price = 3.5 where barcode = '" + barcode +"' ";

        Connection conn = ulti.getConnection();
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

    @Override
    public ArrayList<Item> getItems(){
        ArrayList<Item> items = new ArrayList<Item>();
        String sql = "SELECT * FROM items";

        Item item = null;
        Connection conn = ulti.getConnection();
        try{
            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);
            while (rs.next()){
                item = new Item(rs.getInt("id"), rs.getString("barcode"), rs.getString("name"), rs.getString("unit"), rs.getDouble("price"));
                items.add(item);
            }

            ulti.closeConnection();
            stmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}
