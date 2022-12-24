package service;

import model.Product;
import utils.FileUtils;

import java.util.List;

public class ProductService implements IProductService {
    private FileUtils fileUtils;
    private static ProductService instance;
    public final String PATH = "./data/products.csv";
    private ProductService(){
        fileUtils = FileUtils.getInstance();
    }
    public static ProductService getInstance(){
        if(instance == null)instance = new ProductService();
        return instance;
    }
    @Override
    public void add(Product product) {
        List<Product> products = getAll();
        products.add(product);
        fileUtils.write(PATH,products);
    }

    @Override
    public void isExistById(long id) {

    }

    @Override
    public List<Product> getAll() {
        return fileUtils.readFile(PATH);
    }

    @Override
    public boolean removeById(long id) {
        List<Product> products = getAll();
        for (int i =0; i<products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
            }
        }
        fileUtils.write(PATH,products);
        return true;
    }

    @Override
    public boolean update(Product newProduct) {
        List<Product> products = getAll();
        for (Product p : products) {
            if (p.getId() == newProduct.getId()) {
                if (newProduct.getPrice() != 0) {
                    p.setPrice(newProduct.getPrice());
                }
                if (newProduct.getQuantity()!=0) {
                    p.setQuantity(newProduct.getQuantity());
                }
                if (newProduct.getName() != null) {
                    p.setName(newProduct.getName());
                }
                if (newProduct.getDescription() != null) {
                    p.setDescription(newProduct.getDescription());
                }
                fileUtils.write(PATH,products);
                return true;
            }
        }
        return false;
    }

    @Override
    public void sortByPrice() {

    }

    @Override
    public Product getById(long id) {
        for (Product p : getAll()) {
            if (p.getId()==(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void updateProductId(Product product, long id) {
        for (Product p: getAll()){
            if (p.getId()==product.getId()) {
                p.setId(id);
            }
        }
    }
}
