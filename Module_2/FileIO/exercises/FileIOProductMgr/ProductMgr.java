package FileIOProductMgr;

import java.util.ArrayList;
import java.util.List;

public class ProductMgr {
    private static List<Product> products;


    public static void main(String[] args) {
        products = new ArrayList<>();
        products.add(new Product("Iphone","Apple",23000000));
        products.add(new Product("Iphone","Apple",23000000));
        products.add(new Product("Iphone","Apple",23000000));
        products.add(new Product("Iphone","Apple",23000000));
        String path = "./data/products.csv";
        FOOStream.write(path,products);
        for (Product p :FOIStream.read(path)
             ) {
            System.out.println(p);
        }
    }
}
