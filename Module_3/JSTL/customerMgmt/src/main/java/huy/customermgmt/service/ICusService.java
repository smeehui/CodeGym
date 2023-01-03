package huy.customermgmt.service;

import huy.customermgmt.model.Customer;

import java.util.List;

public interface ICusService {
    List<Customer> getAll();

    void save(Customer customer);

    Customer getById(int id);

    boolean update(int id, Customer customer);

    void remove(int id);
}
