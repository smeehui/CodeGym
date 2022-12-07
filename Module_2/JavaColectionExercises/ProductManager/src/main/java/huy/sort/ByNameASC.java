package huy.sort;

import huy.product.Product;

import java.util.Comparator;

public class ByNameASC implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return CharSequence.compare(o1.getName(), o2.getName());
    }
}
