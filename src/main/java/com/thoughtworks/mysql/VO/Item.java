package com.thoughtworks.mysql.VO;

public class Item {
    private String barcode;

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

    private String name;
    private String unit;
    private double price;

    public Item(String barcode, String name, String unit, double price) {
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
    }
}
