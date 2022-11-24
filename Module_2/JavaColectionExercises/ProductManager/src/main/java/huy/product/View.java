package huy.product;

public class View {
    private ArrayListManagerment products;
    public View(ArrayListManagerment products) {
        this.products = products;
    }
    public void menu() {
        System.out.println("""
                    Menu (enter your selection):
                    1.Add product
                    2.Remove product by id
                    3.Edit product by id
                    4.Display products
                    5.Search by name
                    6.Sort by price
                    """);
    }
    public void showProducts(){
        this.products.show();
    }
}
