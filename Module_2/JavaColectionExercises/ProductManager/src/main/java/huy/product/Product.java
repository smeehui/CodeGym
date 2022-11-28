package huy.product;

public class Product {
    private int amount;
    private String name;
    private double price;
    private String description;
    private int ID;
    public Product(){}
    public Product( String name,int amount, double price,String description) {
        this.amount = amount;
        this.name = name;
        this.price = price;
        this.description = description.equals("")?"No description":description;
        this.ID= generateID();
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int generateID() {
        int old = this.ID;
        int newId;
        do{
            newId = (int) (Math.random()*900+100);
        }while (newId==old);
        return newId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return  getName() +"{" +
                "ID=" + getID() +
                ", amount=" + getAmount() +
                ", price=" + getPrice() +
                ", description='" + getDescription() + '\'' +
                '}';
    }

}