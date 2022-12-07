package huy.sort;

import huy.product.Product;

import java.util.Comparator;

public class ByNameDESC implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return CharSequence.compare(o2.getName(), o1.getName());
    }
}
