package com.thoughtworks.mysql.module;

public class Promotion {
    private int id;
    private String description;
    private int type;
    private double discount;

    public Promotion(String description, int type, double discount) {
        this.description = description;
        this.type = type;
        this.discount = discount;
    }

    public int getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public double getDiscount() {
        return discount;
    }
}

