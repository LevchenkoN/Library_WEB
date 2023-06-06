package com.example.controllers;

import com.example.domain.dao.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.Date;

@Controller
public class BookController {
    @Autowired
    private IBookRepository _repo;

    @RequestMapping("/book/listBooks")
    public ModelAndView list() {
        return new ModelAndView("book/list_books", "books", _repo.findAll());
    }

    @RequestMapping("/book/inUse")
    public ModelAndView inUse() {
        return new ModelAndView("book/in_use", "books", _repo.BooksInUse());
    }

    @RequestMapping("/book/inStock")
    public ModelAndView inStock() {
        return new ModelAndView("/book/in_stock", "books", _repo.BooksInStock());
    }

    @RequestMapping("/book/notReturned")
    public ModelAndView notReturned() {
        return new ModelAndView("book/not_returned", "books", _repo.notReturnedBooks(new Date()));
    }

}
