package com.example.controllers;

import com.example.domain.dao.IAuthorRepository;
import com.example.domain.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorController {
    @Autowired
    private IAuthorRepository _repo;

    @RequestMapping("/author/list")
    public ModelAndView Index() {
        return new ModelAndView("author/list_author", "authors", _repo.findAll());
    }

    @RequestMapping("/add/author/add")
    public ModelAndView Add() {
        return new ModelAndView("author/add_author", "authors", new Object());
    }

    @PostMapping("/author/add")
    public String AuthorAddPost(@RequestParam String fName, @RequestParam String lName) {
        Author author = new Author();
        author.setFirstName(fName);
        author.setLastName(lName);

        _repo.save(author);

        return "redirect:/author/list";
    }

}
