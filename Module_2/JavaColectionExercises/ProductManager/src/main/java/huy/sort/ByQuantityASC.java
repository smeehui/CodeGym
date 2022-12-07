package huy.sort;

import huy.product.Product;

import java.util.Comparator;

public class ByQuantityASC implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
       return Integer.compare(o1.getAmount(), o2.getAmount());
    }
}
