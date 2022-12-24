package view;

import utils.InputUtils;

public class MainMenuView {
    public static void main(String[] args) {
        String[] navigation = {"Xem danh danh sách", "Thêm mới", "Cập nhật", "Xoá",
                "Sắp xếp", "Tìm sản phẩm có giá đắt nhất", "Đọc từ file","Ghi vào file"};
        ListMenu listMenu = new ListMenu("----- CHƯƠNG TRÌNH QUẢNH LÝ SẢN PHẨM -----", navigation);
        InputUtils inputUtils = InputUtils.getInstance();
        ProductView productView = ProductView.getInstance();
        do{
            listMenu.show();
            int option = inputUtils.inputInteger("lựa chọn");
            if (inputUtils.isReturn(String.valueOf(option))) break;
            switch (option){
                case 1 -> productView.showAllWithPage();
                case 2 -> productView.add();
                case 3 -> productView.update();
                case 4 -> productView.remove();
                case 5 -> productView.sort();
                case 6 -> productView.findMostExpensiveProduct();
                case 7 -> productView.readFromFile();
                case 8 -> productView.writeToFile();
            }
        }while (true);
    }
}
