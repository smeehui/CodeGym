package view;

import model.Product;
import service.ProductService;
import utils.FileUtils;
import utils.InputUtils;

import java.util.*;

public class ProductView {
    private static ProductView instance;
    private ProductService productService;
    private InputUtils inputUtils;
    private ListMenu listMenu;
    private Scanner sc;

    private ProductView() {
        productService = ProductService.getInstance();
        inputUtils = InputUtils.getInstance();
        listMenu = new ListMenu();
        sc = new Scanner(System.in);
    }

    public static ProductView getInstance() {
        if (instance == null) instance = new ProductView();
        return instance;
    }

    public void launch() {
    }

    public void showList(List<Product> productList) {
        //1,hoa,12000,10,Hoa mới
        System.out.println("DANH SÁCH SẢN PHẨM");
        System.out.printf("%8s\t%-15s\t%10s\t%8s\t%-25s\n", "ID", "Tên sản phẩm", "Giá", "Số lượng", "Mô tả");
        for (Product product : productList) {
            System.out.printf("%8s\t%-15s\t%10s\t%8s\t%-25s\n",
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getQuantity(),
                    product.getDescription());
        }
    }

    public void showAll() {
        List<Product> productList = productService.getAll();
        showList(productList);
    }

    private void pagination(List<Product> productList,int elmtsPerPage) {
        int page = (int) Math.ceil(productList.size() / elmtsPerPage);
        for (int i = 0; i <= page; i++) {
            if (i==page) {
                showList(productList.subList(i*elmtsPerPage, productList.size()));
                sc.nextLine();
                break;
            };
            showList(productList.subList(i*elmtsPerPage, i*elmtsPerPage + elmtsPerPage));
            sc.nextLine();
        }
    }

    public void add() {
        System.out.println("--Thêm mới sản phẩm--");
        long id = System.currentTimeMillis() / 1000;
        String name = inputUtils.inputString("tên sản phẩm");
        double price = inputPrice();
        int quantity = inputQuantity();
        String description = inputUtils.inputString("mô tả");
        description = description.equals("") ? name + " mới" : description;
        Product product = new Product(id, name, price, quantity, description);
        productService.add(product);
        showAll();
    }

    public void update() {
        do {
            System.out.println("--- Cập nhật sản phẩm---");
            showAll();
            long id = inputUtils.inputLong("ID sản phẩm");
            if (inputUtils.isReturn(String.valueOf(id))) break;
            Product product = productService.getById(id);
            if (product == null) {
                System.out.println("Không tìm thấy sản phẩm");
                continue;
            }
            updateMenuView(id);

        } while (true);
    }

    private void updateMenuView(long id) {
        do {
            Product product = productService.getById(id);
            listMenu.setCaption("---- Chọn trường muốn sửa ----");
            listMenu.setHeaders(new String[]{"Mã sản phẩm", "Tên sản phẩm", "Giá sản phẩm", "Số lượng sản phẩm", "Miêu tả sản phẩm"});
            listMenu.show();
            int option = inputUtils.inputInteger("lựa chọn");
            if (inputUtils.isReturn(String.valueOf(option))) break;
            switch (option) {
                case 1 -> updateProductId(product);
                case 2 -> updateProductName(product.getId());
                case 3 -> updatePrice(product.getId());
                case 4 -> updateQuantity(product.getId());
                case 5 -> updateDescription(product.getId());
            }
        } while (true);

    }

    private void updateProductName(long id) {
        String name = inputUtils.inputString("tên sản phẩm");
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setId(id);
        productService.update(newProduct);
    }

    private void updateDescription(long id) {
        String desc = inputUtils.inputString("mô tả sản phẩm");
        Product newProduct = new Product();
        newProduct.setDescription(desc);
        newProduct.setId(id);
        productService.update(newProduct);
    }

    private void updateQuantity(long id) {
        int quantity = inputQuantity();
        Product newProduct = new Product();
        newProduct.setQuantity(quantity);
        newProduct.setId(id);
        productService.update(newProduct);

    }

    private int inputQuantity() {
        do {
            int quatity = inputUtils.inputInteger("số lượng");
            if (quatity <0) {
                System.out.println("Số lượng không được nhỏ hơn 1");
                continue;
            }
            if (quatity > 999) {
                System.out.println("Số lượng không được lớn hơn 999");
                continue;
            }
            return quatity;
        }while (true);
    }

    private void updatePrice(long id) {
        double price = inputPrice();
        Product newProduct = new Product();
        newProduct.setPrice(price);
        newProduct.setId(id);
        productService.update(newProduct);
    }

    private double inputPrice() {
       do {
           double price = inputUtils.inputDouble("giá sản phẩm");
           if (price < 1000) {
               System.out.println("Giá sản phầm phải lớn hơn 1000");
               continue;
           }
           if (price >100000000) {
               System.out.println("Giá sản phầm phải nhỏ hơn 100.000.000");
               continue;
           }
           return price;
       }while (true);
    }

    private void updateProductId(Product product) {
        long id = inputUtils.inputLong("Mã sản phẩm");
        productService.updateProductId(product, id);
        showAll();
    }

    public void remove() {
        showAll();
        System.out.println("Xoá sản phẩm:");
        long id = inputUtils.inputLong("mã sản phẩm");
        Product product = productService.getById(id);
        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm");
            return;
        }
        List<Product> products = new ArrayList<>();
        products.add(product);
        showList(products);
        boolean confirmed = inputUtils.confirmed("xoá sản phẩm");
        if (confirmed) {
            productService.removeById(id);
            System.out.println("Đã xoá sản phẩm");
        }
    }

    public void sort() {
        List<Product> products = productService.getAll();
        System.out.println("---- Sắp xếp sản phẩm theo giá----");
        System.out.println("1. Tăng dần");
        System.out.println("2. Giảm dần");
        int option = inputUtils.inputInteger("lựa chọn");
        switch (option) {
            case 1 -> sortASCView(products);
            case 2 -> sortDESCView(products);
        }
    }

    private void sortDESCView(List<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) return -1;
                if (o1.getPrice() < o2.getPrice()) return 1;
                return 0;
            }
        });
        showList(products);
        sc.nextLine();
    }

    private Product sortASCView(List<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) return 1;
                if (o1.getPrice() < o2.getPrice()) return -1;
                return 0;
            }
        });
        showList(products);
        sc.nextLine();
        return products.get(products.size() - 1);
    }

    public void findMostExpensiveProduct() {
        System.out.println("Sản phẩm có giá đắt nhất:");
        List<Product> products = productService.getAll();
        List<Product> rs = new ArrayList<>();
        rs.add(sortASCView(products));
        showList(rs);
    }

    public void readFromFile() {
        System.out.println("Đọc từ file sẽ xoá hết thông tin sản phẩm trong bộ nhớ hiện tại");
        boolean confirmed = inputUtils.confirmed("xác nhận tiếp tục");
        if (confirmed) showAll();
    }

    public void writeToFile() {
        System.out.println("Xác nhập cập nhật thông tin sản phẩm trong file");
        boolean confirmed = inputUtils.confirmed("xác nhận tiếp tục");
        if (confirmed) {
            FileUtils fileUtils = FileUtils.getInstance();
            fileUtils.write(productService.PATH,productService.getAll());
            System.out.println("Ghi thành công.");
        }
    }

    public void showAllWithPage() {
        pagination(productService.getAll(),5);
    }
}
