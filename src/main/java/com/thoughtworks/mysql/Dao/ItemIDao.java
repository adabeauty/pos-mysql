package com.thoughtworks.mysql.Dao;

import com.thoughtworks.mysql.module.Item;

import java.util.ArrayList;

public interface ItemIDao {
    Item getItemByBarcode(String barcode);

    void insertItem(Item item);

    void deleteItem(String barcode);

    void updateItem(String barcode);

    ArrayList<Item> getItems();
}
