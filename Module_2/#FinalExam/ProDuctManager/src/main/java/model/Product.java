package model;

public class Product {
    private long id;
    private String name;
    private double price;

    public Product() {
    }

    private int quantity;
    private String description;

    public Product(long id, String name, double price, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", id, name, price, quantity, description);
    }

    public static Product parse(String line) {
        //1,hoa,12000,10,Hoa mới
        String[] parts = line.split(",");
        return new Product(Long.parseLong(parts[0]), parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]),parts[4]);
    }
}
