package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Customers {
    @RequestMapping("/customers")
    public String customers(){
        return "/pages/customers";
    }
}
