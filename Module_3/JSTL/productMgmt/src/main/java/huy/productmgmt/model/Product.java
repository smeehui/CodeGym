package huy.productmgmt.model;

public class Product {
    private int Id;
    private String name;
    private double price;
    private int quantity;
    private boolean available;
    private String desc;

    public Product() {
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Product(int id, String name, double price, int quantity, String desc, boolean available) {
        Id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.desc = desc;
        this.available = available;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
