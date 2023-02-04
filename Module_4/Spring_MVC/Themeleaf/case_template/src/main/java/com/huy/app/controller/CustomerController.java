package com.huy.app.controller;

import com.huy.app.DAO.CustomerDAO;
import com.huy.app.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @GetMapping("/list")
        public String showListCustomer(){
        return "pages/customer/list";
    }
    @GetMapping
    public String showALlCustomer(){
        return showListCustomer();
    }

    @GetMapping("/create")
    public String showCreatingCustomerForm(Model model) {
        model.addAttribute("customer",new Customer());
        return "pages/customer/create";
    }

    @PostMapping("/create")
    public String createNewCustomer(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("customer", new Customer());
        CustomerDAO customerDAO = new CustomerDAO();
        try {
            customerDAO.addNewCustomer(customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "pages/customer/create";
    }
}
