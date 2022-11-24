package huy.product;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayListManagerment products = new ArrayListManagerment();
        initialize(products);
        View view = new View(products);
        Handler handler = new Handler(products);
        int selection = -1;
        while (selection != 0) {
            view.menu();
            selection = Integer.parseInt(sc.nextLine());
            switch (selection) {
                case 1:
                    handler.addNewProduct();
                    break;
                case 2:
                    handler.deleteProductById();
                    break;
                case 3:
                    handler.updateProductById();
                    break;
                case 4:
                    handler.displayProducts();
                    break;

            }
        }

    }


    private static void initialize(ArrayListManagerment products) {
        products.add(new Product("Laptop", 12, 20000, "New Laptop"));
        products.add(new Product("PC", 10, 22000, "New PC"));
        products.add(new Product("Speaker", 22, 10000, "New Speaker"));
        products.add(new Product("TV", 9, 40000, "New TV"));
    }
}
