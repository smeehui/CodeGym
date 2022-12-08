package FileIOProductMgr;

import java.io.Serializable;

public class Product implements Serializable {
    private long ID;
    private String name;
    private String brand;
    private double price;

    @Override
    public String toString() {
        return "Product{" +
               "ID=" + ID +
               ", name='" + name + '\'' +
               ", brand='" + brand + '\'' +
               ", price=" + price +
               '}';
    }

    public Product(String name, String brand, double price) {
        this.ID=System.currentTimeMillis()/1000;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
