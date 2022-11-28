package huy.product;

import java.util.*;


public class Handler {
    private final ProductList list;
    public static Scanner sc = new Scanner(System.in);
    public final View view = new View();

    public Handler(ProductList products) {
        this.list = products;
    }

    public boolean addNewProduct() {
        String selection;
        do {
            System.out.println("Add new product (Enter # to cancel):");
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
        System.out.println("Enter description (optional) : ");
        return sc.nextLine();
    }

    private String enterName() {
        System.out.println("Enter product name: ");
        return sc.nextLine();
    }

    public int validateIntInput(String field) {
        String input;
        boolean hasError;
        do {
            System.out.println("Enter " + field + ": ");
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
            System.out.println("Enter " + field + ": ");
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
        show(list.getProdList());
        do {
            if (list.isEmpty()) {
                System.out.println("There are no products in the list, press enter");
                sc.nextLine();
                return;
            }
            int id = enterId();
            if (id < 0) break;
            boolean status = list.removeById(id);
            if (status) show(list.getProdList());
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
        show(list.getProdList());
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
                    show(list.getProdList());
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
            show(list.getProdList());
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
        do{
            String name = enterName();
            if (name.equals("#")) break;
            ArrayList<Product> result = list.searchProductByName(name);
            displaySearch(result);
        }while(!sc.nextLine().equals("#"));
    }

    private void displaySearch(ArrayList<Product> result) {
        if (result.size() == 0) {
            System.out.println("No product found, press enter to continue, # to return");
            return;
        }
        System.out.println("Products found, enter to continue, # to return:");
        show(result);
    }
public void show(ArrayList<Product> list) {
        System.out.printf("%15s%n", "Product list");
        System.out.printf("%-3s", "#");
        System.out.printf("%5s", "ID");
        System.out.print("   ");
        System.out.printf("%-30s", "NAME");
        System.out.printf("%10s", "QUANTITY");
        System.out.printf("%15s", "PRICE");
        System.out.print("   ");
        System.out.printf("%-50s", "DESCRIPTION");
        int count = 0;
        for (Product product : list) {
            System.out.println();
            System.out.printf("%-3d", ++count);
            System.out.printf("%5d", product.getID());
            System.out.print("   ");
            System.out.printf("%-30s", product.getName());
            System.out.printf("%10s", product.getAmount());
            System.out.printf(Locale.US, "%,15.2f", product.getPrice());
            System.out.print("   ");
            System.out.printf("%-50s", product.getDescription());
        }
        System.out.println();
    }

    public void sortByPrice() {
        while (true) {
            view.sortByPriceMenu();
            int selection = validateIntInput("selection");
            if (selection == -1) break;
            if (selection ==1){
                list.getProdList().sort((o1, o2) -> {
                    if (o1.getPrice() < o2.getPrice()) return -1;
                    return o1.getPrice() > o2.getPrice() ? 1 : 0;
                });
                show(list.getProdList());
                System.out.println("Sorted ascending by price, press enter");
                sc.nextLine();
            }else if (selection ==2){
                list.getProdList().sort((o1, o2) -> {
                    if (o1.getPrice() < o2.getPrice()) return 1;
                    return o1.getPrice() > o2.getPrice() ? -1 : 0;
                });
                show(list.getProdList());
                System.out.println("Sorted descending by price, press enter");
                sc.nextLine();
            }

        }
    }

    public void exit() {
        System.out.println("Good bye!");
        System.exit(0);
    }
}
