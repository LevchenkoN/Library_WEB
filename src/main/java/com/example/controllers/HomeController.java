package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    @GetMapping("/")
    public String registrationForm() {
        return "book/list_books";
    }
    @RequestMapping("/about")
    public ModelAndView About() {
        return new ModelAndView("home/about", "data", new Object());
    }

}
