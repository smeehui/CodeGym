package huy.productmgmt.service;

import huy.productmgmt.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProdService{
    static Map<Integer,Product> products;
    static {
        products = new HashMap<>();
        products.put(100,new Product(100,"Samsung",12500000,5,"Like new",true));
        products.put(101,new Product(101,"iPhone 11",13500000,5,"Hàng mới 99%",true));
        products.put(102,new Product(102,"iPhone 14",23500000,5,"Mới nhập",false));
        products.put(103,new Product(103,"Samsung Galaxy Z-Fold",25500000,5,"Like new",true));
    }
    public ProductService(){

    }
    @Override
    public Map<Integer, Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        return products.get(id);
    }

    @Override
    public void addNew(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void changeStatus(int id,boolean available) {
        products.get(id).setAvailable(available);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void updateStatus(int id) {
        Product product = getById(id);
        product.setAvailable(!product.isAvailable());
    }

    @Override
    public Map<Integer,Product> getByName(String query) {
        Map<Integer,Product> result = new HashMap<>();
        for (Product p : products.values()){
            if (p.getName().toLowerCase().contains(query)) result.put(p.getId(),p);
        }
        return result;
    }
}
