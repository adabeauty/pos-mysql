package com.thoughtworks.mysql.service;

import com.thoughtworks.mysql.Dao.ItemDao;
import com.thoughtworks.mysql.module.Item;
import java.util.ArrayList;

public class ItemService implements ItemIService {
    ItemDao itemDao = new ItemDao();
    @Override
    public Item getItemByBarcode(String barcode) {
        //可以在ItemDao的基础上
        Item item = itemDao.getItemByBarcode(barcode);
        return item;
    }

    @Override
    public void insertItem(Item item) {
        itemDao.insertItem(item);
    }

    @Override
    public void deleteItem(String barcode) {
        itemDao.deleteItem(barcode);
    }

    @Override
    public void updateItem(String barcode) {
        itemDao.updateItem(barcode);
    }

    @Override
    public ArrayList<Item> getItems() {
        ArrayList<Item> items = itemDao.getItems();
        return items;
    }
}
