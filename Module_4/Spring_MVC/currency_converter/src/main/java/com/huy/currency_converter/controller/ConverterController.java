package com.huy.currency_converter.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ConverterController {
    @GetMapping("/")
    public String redirectToHome(){
        return "input";
    }

    @PostMapping(value = "/convert")
    public String convert(
            @RequestParam String type,
            @RequestParam String amount,
            @RequestParam String rate,
            Model model
    ) {
        double result = Double.parseDouble(amount)*Double.parseDouble(rate);
        if (type.equals("u2v")) {
            model.addAttribute("from","USD");
            model.addAttribute("to", "VND");
        }else {
            model.addAttribute("from","USD");
            model.addAttribute("to", "VND");
        }
        model.addAttribute("amount", amount);
        model.addAttribute("rate", rate);
        model.addAttribute("result", result);
        return "result";
    }
}
