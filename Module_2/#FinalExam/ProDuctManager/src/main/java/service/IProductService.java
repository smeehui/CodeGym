package service;

import model.Product;

import java.util.List;

public interface IProductService {
    void add(Product product);

    void isExistById(long id);
    List<Product> getAll();
    boolean removeById(long id);
    boolean update(Product product);
    void sortByPrice();

    Product getById(long id);

    void updateProductId(Product product, long id);
}
