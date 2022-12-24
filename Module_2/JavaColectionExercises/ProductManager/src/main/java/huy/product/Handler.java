package huy.product;

import huy.sort.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Handler {
    private final ProductList list;
    public static Scanner sc = new Scanner(System.in);
    public final View view = new View();

    public Handler() {
        ArrayList<Product> localData = this.readData();
        if (localData!=null) {
            list = new ProductList(localData);
        }else list = new ProductList();
        initialize(list);
    }

    private void initialize(ProductList list) {
        list.add(new Product("PC", 12,4000000,""));
        list.add(new Product("PC", 12,4000000,""));
        list.add(new Product("PC", 12,4000000,""));
        list.add(new Product("PC", 12,4000000,""));
        list.add(new Product("PC", 12,4000000,""));
    }

    public boolean addNewProduct() {
        String selection;
        do {
            view.subMenu("Add new product");
            String name = enterName();
            if (name.equals("#")) return false;
            double price = validateDoubleInput("price");
            if (price < 0) break;
            int quantity = validateIntInput("quantity");
            if (quantity < 0) break;
            String description = enterDescription();
            if (description.equals("#")) return false;
            list.add(new Product(name, quantity, price, description));
            System.out.println("Added product, enter to continue");
            selection = sc.nextLine();
        } while (!selection.equals("#"));
        return true;
    }

    private String enterDescription() {
        System.out.print("Enter description (optional) : ");
        return sc.nextLine();
    }

    private String enterName() {
        System.out.print("Enter product name: ");
        return sc.nextLine();
    }

    public int validateIntInput(String field) {
        String input;
        boolean hasError;
        do {
            System.out.print("Enter " + field + ": ");
            input = sc.nextLine();
            if (input.equals("#")) return -1;
            hasError = !new CheckInputException(CheckInputException.Type.INT, input).check();
            if (hasError)
                System.out.println(field.substring(0, 1).toUpperCase() + field.substring(1) + " must be a number");
        } while (hasError);
        return Integer.parseInt(input);
    }

    public double validateDoubleInput(String field) {
        String input;
        boolean hasError;
        do {
            System.out.print("Enter " + field + ": ");
            input = sc.nextLine();
            if (input.equals("#")) return -1;
            hasError = !new CheckInputException(CheckInputException.Type.DOUBLE, input).check();
            if (hasError)
                System.out.println(field.substring(0, 1).toUpperCase() + field.substring(1) + " must be a number");
        } while (hasError);
        return Double.parseDouble(input);
    }

    public void deleteProductById() {
        String selection = "";
        view.show(list.getProdList());
        do {
            if (list.isEmpty()) {
                System.out.println("There are no products in the list, press enter");
                sc.nextLine();
                return;
            }
            int id = enterId();
            if (id < 0) break;
            boolean status = list.removeById(id);
            if (status) view.show(list.getProdList());
            else {
                System.out.println("Product not found");
                selection = sc.nextLine();
            }
        } while (!selection.equals("#"));
    }

    private int enterId() {
        boolean hasError;
        String input;
        do {
            System.out.println("Enter id (# to return):");
            input = sc.nextLine();
            if (input.equals("#")) return -1;
            hasError = !new CheckInputException(CheckInputException.Type.INT, input).check();
            if (hasError) {
                System.out.println("Id must be a number");
            }
        } while (hasError);
        return Integer.parseInt(input);
    }


    public void updateProductById() {
        if (list.isEmpty()) {
            System.out.println("There are no products in the list, press enter");
            sc.nextLine();
            return;
        }
        view.show(list.getProdList());
        do {
            int id = enterId();
            if (id < 0) break;
            if (!list.isExist(id)) {
                System.out.println("Product not found");
                sc.nextLine();
            } else {
                String name = enterName();
                if (name.equals("#")) break;
                double price = validateDoubleInput("price");
                if (price < 0) break;
                int quantity = validateIntInput("quantity");
                if (quantity < 0) break;
                String description = enterDescription();
                if (description.equals("#")) break;
                boolean status = list.updateProductById(new Product(name, quantity, price, description), id);
                if (status) {
                    System.out.println("Updated successfully");
                    view.show(list.getProdList());
                }
                if (sc.nextLine().equals("#")) break;
            }
        } while (true);
    }

    public void displayProducts() {
        if (list.isEmpty()) {
            System.out.println("There are no products in the list, press enter");
            sc.nextLine();
        } else {
            view.pagination(list.getProdList(), 10);
            System.out.println("Press enter to return");
            sc.nextLine();
        }
    }

    public void searchProductByName() {
        if (list.isEmpty()) {
            System.out.println("There are no products in the list, press enter");
            sc.nextLine();
            return;
        }
        do {
            String name = enterName();
            if (name.equals("#")) break;
            displaySearch(list.searchProductByName(name));
        } while (!sc.nextLine().equals("#"));
    }

    private void displaySearch(ArrayList<Product> result) {
        if (result.size() == 0) {
            System.out.println("No product found, press enter to continue, # to return");
            return;
        }
        System.out.println("Products found, enter to continue, # to return:");
        view.pagination(result, 5);
    }


    public void exit() {
        System.out.println("Good bye!");
        System.exit(0);
    }

    public void sort() {
        if (list.isEmpty()) {
            System.out.println("There are no products in the list, press enter");
            sc.nextLine();
            return;
        }
        int selection;
        while (true) {
            view.menu("Sort by:", "Price", "Name", "Quantity");
            selection = validateIntInput("selection");
            if (selection == -1) break;
            switch (selection) {
                case 1 -> {
                    view.sortSubMenus("Sort by Price:");
                    selection = validateIntInput("");
                    if (selection == -1) break;
                    if (selection == 1) {
                        list.getProdList().sort(new ByPriceASC());
                        view.pagination(list.getProdList(), 10);
                    } else if (selection == 2) {
                        list.getProdList().sort(new ByPriceDESC());
                        view.pagination(list.getProdList(), 10);
                    }
                }
                case 2 -> {
                    view.sortSubMenus("Sort by Name:");
                    selection = validateIntInput("");
                    if (selection == -1) break;
                    if (selection == 1) {
                        list.getProdList().sort(new ByNameASC());
                        view.pagination(list.getProdList(), 10);
                    }
                    if (selection == 2) {
                        list.getProdList().sort(new ByNameDESC());
                        view.pagination(list.getProdList(), 10);
                    }
                }
                case 3 -> {
                    view.sortSubMenus("Sort by quantity:");
                    selection = validateIntInput("");
                    if (selection == -1) break;
                    if (selection == 1) {
                        list.getProdList().sort(new ByQuantityASC());
                        view.pagination(list.getProdList(), 10);
                    }
                    if (selection == 2) {
                        list.getProdList().sort(new ByQuantityDESC());
                        view.pagination(list.getProdList(), 10);
                    }
                }
            }

        }

    }

    public void writeToFile() {
        view.menu("Export as:", "Text document in table", "CSV format");
        int selection;
        do {
            selection = validateIntInput("selection");
            if (selection == -1) break;
            switch (selection) {
                case 1 -> {
                    File file = new File("");
                    try {
                        FileWriter writer = new FileWriter(file.getCanonicalPath() + "/files/products.txt");
                        BufferedWriter buffer = new BufferedWriter(writer);
                        buffer.write(view.show(list.getProdList()));
                        buffer.close();
                        writer.close();
                        System.out.println("Exported successfully at "+ file.getCanonicalPath()+ "/files/products.txt");
                    } catch (IOException e) {
                        System.out.println("Write failed: " + e.getMessage());
                    }
                }
                case 2 -> {
                    File file = new File("");
                    try {
                        FileWriter writer = new FileWriter(file.getCanonicalPath() + "/files/products.tsv");
                        BufferedWriter buffer = new BufferedWriter(writer);
                        ArrayList<Product> products = list.getProdList();
                        for (Product product : products) {
                            buffer.write(String.valueOf(product.getID()));
                            buffer.write("\t");
                            buffer.write(product.getName());
                            buffer.write("\t");
                            buffer.write(String.valueOf(product.getPrice()));
                            buffer.write("\t");
                            buffer.write(String.valueOf(product.getAmount()));
                            buffer.write("\t");
                            buffer.write(String.valueOf(product.getDescription()));
                            buffer.write("\t");
                            buffer.write(product.getDateAdded());
                            buffer.write("\n");
                        }
                        buffer.close();
                        writer.close();
                        System.out.println("Exported successfully at " + file.getCanonicalPath() + "/files/products.tsv");
                    } catch (IOException e) {
                        System.out.println("Write failed: " + e.getMessage());
                    }
                }
            }
        } while (true);
    }
    public  ArrayList<Product> readData() {
        File file = new File("");
        ArrayList<Product> dataProducts = new ArrayList<>();
        try {
            FileReader reader = new FileReader(file.getCanonicalPath() + "/files/products.tsv");
            BufferedReader bf = new BufferedReader(reader);
            while (true) {
                String line = bf.readLine();
                if (line == null) break;
                String[] values = line.split("\t");
                int id = Integer.parseInt(values[0].trim());
                String name = values[1];
                double price = Double.parseDouble(values[2].trim());
                int quantity = Integer.parseInt(values[3].trim());
                String description = values[4];
                String date = values[5];
                Product product = new Product(name, quantity, price, description);
                product.setID(id);
                product.setDateAdded(date);
                dataProducts.add(product);
            }
            return dataProducts;
        } catch (IOException e) {
            System.out.println("File not found:");
            return null;
        }
    }
}
