package huy.product;


public class App {

    public static void main(String[] args) {
        ProductList products = new ProductList();
        initialize(products);
        View view = new View();
        Handler handler = new Handler(products);
        int selection;
        while (true) {
            view.menu();
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
                    handler.sortByPrice();
                    break;
                case 0:
                    handler.exit();
                default:
            }
        }

    }


    private static void initialize(ProductList products) {
        products.add(new Product("Laptop", 12, 20000, "New Laptop"));
        products.add(new Product("PC", 10, 22000, "New PC"));
        products.add(new Product("Speaker", 22, 10000, "New Speaker"));
        products.add(new Product("TV", 9, 40000, "New TV"));
        products.add(new Product("Laptop", 12, 20000, "New Laptop"));
        products.add(new Product("PC", 10, 22000, "New PC"));
        products.add(new Product("Speaker", 22, 10000, "New Speaker"));
        products.add(new Product("TV", 9, 40000, "New TV"));
    }
}
