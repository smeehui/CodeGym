package huy.product;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
//    private static ProductList products= new ProductList();
    private static Handler handler = new Handler();
    public static void main(String[] args) {
        View view = new View();
        int selection;
        while (true) {
            view.menu("Menu (enter your selection):","Add product", "Remove product by id", "Edit product by id", "Display products", "Search by name", "Sort","Export as");
            selection = handler.validateIntInput("Selection");
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
                case 5:
                    handler.searchProductByName();
                    break;
                case 6:
                    handler.sort();
                    break;
                case 7:
                    handler.writeToFile();
                    break;
                case 8:
                    handler.readData();
                    break;
                case -1:
                    handler.exit();
                default:
            }
        }

    }
}
