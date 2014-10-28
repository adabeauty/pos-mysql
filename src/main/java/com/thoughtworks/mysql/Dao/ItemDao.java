package com.thoughtworks.mysql.Dao;

import com.thoughtworks.mysql.module.Item;
import com.thoughtworks.mysql.ulti.Ulti;

import java.sql.*;
import java.util.ArrayList;

public class ItemDao implements ItemIDao {

    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Ulti ulti= new Ulti();

    @Override
    public Item getItemByBarcode(String barcode){
        /*String sql = "SELECT * FROM items WHERE barcode = '"+ barcode +"'";*/
        String sql = "SELECT * FROM items WHERE barcode = ?";
        Item item = null;
        Connection conn = ulti.getConnection();
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, barcode);
            rs = pstmt.executeQuery(sql);
            rs.next();
            item = new Item(rs.getInt("id"), rs.getString("barcode"), rs.getString("name"), rs.getString("unit"), rs.getDouble("price"));

            ulti.closeConnection();
            pstmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void insertItem(Item item){
        String sql = "insert into items values(null, ?, ?, ?, ?)";

        Connection conn = ulti.getConnection();
        try{
            //DML(数据操纵语言insert,)
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, item.getBarcode());
            pstmt.setString(2,item.getName());
            pstmt.setString(3, item.getUnit());
            pstmt.setDouble(4, item.getPrice());

            int result = pstmt.executeUpdate(sql);

            ulti.closeConnection();
            pstmt.close();

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
        String sql = "DELETE FROM items where barcode = ? ";

        Connection conn = ulti.getConnection();
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, barcode);

            //DML(数据操纵语言insert,)
            int result = pstmt.executeUpdate(sql);

            ulti.closeConnection();
            pstmt.close();

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

        String sql = "UPDATE items SET name = 'cocacola', unit = 'can', price = 3.5 where barcode = ? ";

        Connection conn = ulti.getConnection();
        try{
            //DML(数据操纵语言insert,)
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, barcode);

            int result = pstmt.executeUpdate(sql);

            conn.close();
            pstmt.close();

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
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery(sql);
            while (rs.next()){
                item = new Item(rs.getInt("id"), rs.getString("barcode"), rs.getString("name"), rs.getString("unit"), rs.getDouble("price"));
                items.add(item);
            }

            ulti.closeConnection();
            pstmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}
