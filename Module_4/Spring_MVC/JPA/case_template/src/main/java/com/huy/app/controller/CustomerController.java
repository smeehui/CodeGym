package com.huy.app.controller;

import com.huy.app.model.Customer;
import com.huy.app.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/list")
        public String showListCustomer(){
        return "pages/customer/list";
    }
    @GetMapping
    public String showALlCustomer(){
        return showListCustomer();
    }

    @GetMapping("/create")
    public ModelAndView showCreatingCustomerForm() {
        ModelAndView modelAndView = new ModelAndView("pages/customer/create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createNewCustomer(@ModelAttribute Customer customer, Model model) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("pages/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return "pages/customer/create";
    }
}
