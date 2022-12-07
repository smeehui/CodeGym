package huy.sort;

import huy.product.Product;

import java.util.Comparator;

public class ByQuantityDESC implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o2.getAmount(), o1.getAmount());
    }
}
