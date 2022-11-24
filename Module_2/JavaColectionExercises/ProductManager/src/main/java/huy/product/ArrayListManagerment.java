package huy.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class ArrayListManagerment {
    private final ArrayList<Product> prodList;

    public ArrayListManagerment() {
        prodList = new ArrayList<>();
    }

    public ArrayListManagerment(Product product) {
        prodList = new ArrayList<>();
    }

    public boolean add(Product product) {
        prodList.add(product);
        return true;
    }

    @Override
    public String toString() {
        return "prodList=" + Arrays.toString(prodList.toArray());
    }

    public void show() {
        System.out.printf("%15s%n", "Product list");
        System.out.printf("%-3s", "#");
        System.out.printf("%5s", "ID");
        System.out.print("   ");
        System.out.printf("%-30s", "NAME");
        System.out.printf("%10s", "QUANTITY");
        System.out.printf("%15s", "PRICE");
        System.out.print("   ");
        System.out.printf("%-50s", "DESCRIPTION");
        int count = 0;
        for (Product product : prodList) {
            System.out.println();
            System.out.printf("%-3d", ++count);
            System.out.printf("%5d", product.getID());
            System.out.print("   ");
            System.out.printf("%-30s", product.getName());
            System.out.printf("%10s", product.getAmount());
            System.out.printf(Locale.US, "%,15.2f", product.getPrice());
            System.out.print("   ");
            System.out.printf("%-50s", product.getDescription());
        }
        System.out.println();
    }

    public boolean removeById(int id) {
        for (Product product : prodList) {
            if (product.getID() == id) {
                prodList.remove(product);
                return true;
            }
        }
        return false;
    }
    public boolean isEmpty(){
        return prodList.isEmpty();
    }
    public boolean updateProductById(Product product,int id){
      for (Product p: prodList){
          if (p.getID() == id){
              p.setName(product.getName());
              p.setAmount(product.getAmount());
              p.setPrice(product.getPrice());
              p.setDescription(product.getDescription());
              return true;
          }
      }return false;
    }
    public boolean isExist(int id){
        for (Product product : prodList) {
            if (product.getID() == id) {
                return true;
            }
        }
        return false;
    }
    public ArrayList<Product> searchProductByName(String name){
        ArrayList<Product> result = new ArrayList<>();
        if(this.isEmpty()) return result;
        for (Product product : prodList) {
            if (product.getName().matches(name)) {
                result.add(product);
            }
        }
        return result;
    }
}
