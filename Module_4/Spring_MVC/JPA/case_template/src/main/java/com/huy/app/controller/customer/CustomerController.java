package com.huy.app.controller.customer;

import com.huy.app.model.Customer;
import com.huy.app.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/list")
        public ModelAndView showListCustomer(){
        ModelAndView modelAndView = new ModelAndView("pages/customer/list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
    @GetMapping
    public ModelAndView showALlCustomer(){
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
