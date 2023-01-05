package huy.customerlist;

public class Customer {
    private String name;
    private String address;
    private String dOB;
    private String img;

    public Customer(String name, String address, String dOB, String img) {
        this.name = name;
        this.address = address;
        this.dOB = dOB;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDOB() {
        return dOB;
    }

    public String getImg() {
        return img;
    }
}
