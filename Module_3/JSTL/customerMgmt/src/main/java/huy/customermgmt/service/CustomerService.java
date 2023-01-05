package huy.customermgmt.service;

import huy.customermgmt.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICusService {
    public static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "Huy Nguyễn", "huy@gmail.com", "Huế"));
        customers.put(2, new Customer(2, "Anh Nguyễn", "anh@gmail.com", "Hà Nội"));
        customers.put(3, new Customer(3, "Ly Nguyễn", "ly@gmail.com", "Phú Yên"));
        customers.put(4, new Customer(4, "Mây Nguyễn", "may@gmail.com", "Huế"));
        customers.put(5, new Customer(5, "Long Trần", "long@gmail.com", "Hải Phòng"));
        customers.put(6, new Customer(6, "Kim Lý", "kim@gmail.com", "Nam Định"));
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer getById(int id) {
        return customers.get(id);
    }

    @Override
    public boolean update(int id, Customer customer) {
        if (customers.get(id) == null) return false;
        customers.put(id, customer);
        return true;
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
