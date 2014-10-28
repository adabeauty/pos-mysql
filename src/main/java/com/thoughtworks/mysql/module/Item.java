package com.thoughtworks.mysql.module;

public class Item {

    private int id;
    private String barcode;
    private String name;
    private String unit;
    private double price;

    public Item(int id, String barcode, String name, String unit, double price) {
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getPrice() {
        return price;
    }
}
