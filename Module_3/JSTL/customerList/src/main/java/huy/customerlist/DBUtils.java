package huy.customerlist;

import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    private  static List<Customer> customers;
    public static void init(){
        customers = new ArrayList<>();
        customers.add(new Customer("Huy Nguyễn","Huế","26-09-1999","./img/download.jpeg"));
        customers.add(new Customer("Trọng Anh","Hà Nội","26-09-1995","./img/download.jpeg"));
        customers.add(new Customer("Phi Long","Huế","26-09-2003","./img/download.jpeg"));
    }
    public static List<Customer> queryDataBase(){
        init();
        return customers;
    }
}
