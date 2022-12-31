package huy.productmgmt.service;

import huy.productmgmt.model.Product;

import java.util.List;
import java.util.Map;

public interface IProdService {
    Map<Integer, Product> getAll();
    Product getById(int id);
    void addNew(Product product);

    void changeStatus(int id,boolean status);

    void update(int id, Product product);
    void updateStatus(int id);

    Map<Integer,Product> getByName(String query);
}
