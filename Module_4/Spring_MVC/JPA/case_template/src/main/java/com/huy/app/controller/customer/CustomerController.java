package com.huy.app.controller.customer;

import com.huy.app.model.Customer;
import com.huy.app.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
        modelAndView.addObject("view", "create");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditCustomerForm(@PathVariable String id){
        Long idLong = null;
        try {
            idLong = Long.parseLong(id);
        }catch (NumberFormatException e){}
        ModelAndView modelAndView = new ModelAndView("pages/customer/create");
        modelAndView.addObject("customer",customerService.findById(idLong));
        modelAndView.addObject("view", "edit");
        return modelAndView;
    }
    @PostMapping("/create")
    public String createNewCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customer);
            return "pages/customer/create";
        }
       else {
            customerService.save(customer);
            model.addAttribute("message", "New customer created successfully");
            return "redirect:/customer/create";
        }
    }
    @PostMapping("/edit/{id}")
    public String updateCustomer(@PathVariable String id,@ModelAttribute Customer customer){
        Long idLong = null;
        try {
            idLong = Long.parseLong(id);
        }catch (NumberFormatException e){}
        customer.setId(idLong);
        customer.setBalance(0);
        customerService.save(customer);
        return "redirect:/customer/";
    }
}
