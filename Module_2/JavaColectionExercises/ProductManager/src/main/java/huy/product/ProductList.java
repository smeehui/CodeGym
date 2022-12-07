package huy.product;

import java.util.*;

public class ProductList {
    private final ArrayList<Product> prodList = new ArrayList<>();

    public ArrayList<Product> getProdList() {
        return prodList;
    }

    public ProductList() {
    }
    public ProductList(ArrayList<Product> product) {
        this.prodList.addAll(product);
    }

    public ProductList(Product product) {
        prodList.add(product);
    }

    private void generateID(ArrayList<Product> prodList, Product product) {
        for (Product prod : prodList) {
           if (product.getID() == prod.getID()){
               product.setID(product.generateID());
               generateID(prodList, product);
           }
        }
    }

    public boolean add(Product product) {
        generateID(prodList, product);
        prodList.add(product);
        return true;
    }
    public  void addAll(ArrayList<Product> list){
        prodList.addAll(list);
    }

    @Override
    public String toString() {
        return "prodList=" + Arrays.toString(prodList.toArray());
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
            if (product.getName().toUpperCase().contains(name.toUpperCase())) {
                result.add(product);
            }
        }
        return result;
    }
}
