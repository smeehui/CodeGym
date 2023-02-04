package com.demo.uri_pattern_demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
class Test {
    @RequestMapping("/test")
    public ModelAndView uri1() {
        ModelAndView model = new ModelAndView("index");
        model.addObject("message", "uri1");
        return model;
    }
//    @RequestMapping("/test2")
    public ModelAndView uri2() {
        ModelAndView model = new ModelAndView("/WEB-INF/jsp/index.jsp");
        model.addObject("message", "uri2");
        return model;
    }
    @RequestMapping("/test2")
    public String doA(Model model) {
        model.addAttribute("message", "test2 servlet");
        return "index";
    }
}
