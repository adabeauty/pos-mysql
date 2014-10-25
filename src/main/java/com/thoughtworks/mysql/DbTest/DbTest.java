package com.thoughtworks.mysql.DbTest;

import com.thoughtworks.mysql.DAO.ItemDao;
import com.thoughtworks.mysql.VO.Item;

public class DbTest {

    public static void main(String[] args){
        DbTest dbTest = new DbTest();
        Item item = new Item("TF1003", "apple", "kg", 8.00);
        ItemDao itemDao = new ItemDao();
        itemDao.insertItem(item);
    }
}
