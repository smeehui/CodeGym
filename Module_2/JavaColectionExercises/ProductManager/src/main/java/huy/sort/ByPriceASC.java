package huy.sort;

import huy.product.Product;

import java.util.Comparator;

public class ByPriceASC implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
