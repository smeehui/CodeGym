package huy.product;

import java.util.Scanner;

public class Handler {
    private final ArrayListManagerment list;
    public static Scanner sc = new Scanner(System.in);

    public Handler(ArrayListManagerment products) {
        this.list = products;
    }

    public boolean addNewProduct() {
        String selection;
        do {
            System.out.println("Add new product (Enter # to cancel):");
            String name = enterName();
            if (name.equals("#")) return false;
            double price = enterPrice();
            if (price < 0) break;
            int quantity = enterQuantity();
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

    private int enterQuantity() {
        String input;
        boolean hasError;
        do {
            System.out.println("Enter product quantity: ");
            input = sc.nextLine();
            if (input.equals("#")) return -1;
            hasError = !new CheckInputException(CheckInputException.Type.INT, input).check();
            if (hasError) System.out.println("Price must be a number");
        } while (hasError);
        return Integer.parseInt(input);
    }

    private double enterPrice() {
        String input;
        boolean hasError;
        do {
            System.out.println("Enter product price: ");
            input = sc.nextLine();
            if (input.equals("#")) return -1;
            hasError = !new CheckInputException(CheckInputException.Type.DOUBLE, input).check();
            if (hasError) System.out.println("Price must be a number");
        } while (hasError);
        return Double.parseDouble(input);
    }

    public void deleteProductById() {
        String selection = "";
        list.show();
        do {
            if (list.isEmpty()) {
                System.out.println("There are no products in the list, press enter");
                sc.nextLine();
                return;
            }
            int id = enterId();
            if (id < 0) break;
            boolean status = list.removeById(id);
            if (status) list.show();
            else {
                System.out.println("Product not found");
                selection = sc.nextLine();
            }
        } while (!selection.equals("#"));
    }

    private int enterId() {
        boolean hasError;
        String  input;
        do{
            System.out.println("Enter id (# to return):");
            input = sc.nextLine();
            if(input.equals("#")) return -1;
            hasError =!new CheckInputException(CheckInputException.Type.INT, input).check();
            if(hasError) {
                System.out.println("Id must be a number");
            }
        }while (hasError);
        return Integer.parseInt(input);
    }

    public void updateProductById() {
        if (list.isEmpty()) {
            System.out.println("There are no products in the list, press enter");
            sc.nextLine();
            return;
        }
        list.show();
        do{
            int id = enterId();
            if (id < 0) break ;
            if(!list.isExist(id)) {
                System.out.println("Product not found");
                sc.nextLine();
            }else {
                String name = enterName();
                if (name.equals("#")) break ;
                double price = enterPrice();
                if (price < 0) break;
                int quantity = enterQuantity();
                if (quantity < 0) break;
                String description = enterDescription();
                if (description.equals("#")) break ;
                boolean status = list.updateProductById(new Product(name, quantity,price ,description),id);
                if (status) {
                    System.out.println("Updated successfully");
                    list.show();
                };
                if (sc.nextLine().equals("#")) break;
            }
        }while (true);
    }

    public void displayProducts() {
        if (list.isEmpty()) {
            System.out.println("There are no products in the list, press enter");
            sc.nextLine();
        }else {
            list.show();
            System.out.println("Press enter to return");
            sc.nextLine();
        }
    }
}
