package huy.product;

import java.util.*;

public class ProductList {
    private final ArrayList<Product> prodList;

    public ArrayList<Product> getProdList() {
        return prodList;
    }

    public ProductList() {
        prodList = new ArrayList<>();
    }

    public ProductList(Product product) {
        prodList = new ArrayList<>();
        prodList.add(product);
        generateID(prodList);
    }

    private void generateID(ArrayList<Product> prodList) {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Product prod : prodList) {
            ids.add(prod.getID());
        }
        for(int i = 0; i < ids.size(); i++){
            for (int j = i; j < ids.size(); j++) {
                while (prodList.get(i).getID() == (ids.get(j))) {
                    prodList.get(i).generateID();
                }
            }
        }

    }

    public boolean add(Product product) {
        prodList.add(product);
        return true;
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
            if (product.getName().matches("(.*)"+name+"(.*)")) {
                result.add(product);
            }
        }
        return result;
    }
}
