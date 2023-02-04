package com.smee.productmgmt.product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String color;
    private String desc;
    private int category;
    public Product() {
    }
    public Product(int id, String name, double price, int quantity, String color, String desc, int category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.desc = desc;
        this.category = category;
    }

    public static Product parse(ResultSet rs) throws SQLException {
        int id = Integer.parseInt(rs.getString("id"));
        String name = rs.getString("name");
        double price = rs.getDouble("price");
        int quantity = rs.getInt("quantity");
        String color = rs.getString("color");
        String desc = rs.getString("description");
        int category = rs.getInt("category");
        return new Product(id, name, price, quantity, color, desc, category);
    }

    public Product(String name, double price, int quantity, String color, String desc, int category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.desc = desc;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
