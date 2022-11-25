package huy.product;

public class View {
    public View() {
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
                    0.Exit
                    """);
    }

    public void sortByPriceMenu() {
        System.out.println("""
                Sort by price:
                1. Ascending order
                2. Descending order
                """);
    }
}
