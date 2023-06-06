package com.example.controllers;

import com.example.domain.dao.IBookRepository;
import com.example.domain.dao.ILibrarianRepository;
import com.example.domain.dao.ISCardRepository;
import com.example.domain.dao.IStudentRepository;
import com.example.domain.models.SCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class IssueBooksController {
    @Autowired
    private IStudentRepository _repoStudent;

    @Autowired
    private IBookRepository _repoBook;

    @Autowired
    private ILibrarianRepository _repoLibrarian;

    @Autowired
    private ISCardRepository _repoSCard;

    @RequestMapping("/issueBooks/students")
    public ModelAndView IssueBooksStudents() {
        ModelAndView mv= new ModelAndView("issue_books/students", "students", _repoStudent.findAll() );
        mv.addObject("librarians", _repoLibrarian.findAll());
        mv.addObject("books", _repoBook.findAll());
        return mv;
    }

    @PostMapping("/issueBooks/students")
    public ResponseEntity<Void> goStudentPost(@RequestParam String book, @RequestParam String student, @RequestParam String date, @RequestParam String librarian) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        SCard sCard = new SCard();
        sCard.setBook(_repoBook.getReferenceById(Long.parseLong(book)));
        sCard.setStudent(_repoStudent.getReferenceById(Long.parseLong(student)));
        sCard.setLibrarian(_repoLibrarian.getReferenceById(Long.parseLong(librarian)));
        sCard.setDateIn(new Date());
        sCard.setDateOut(formatter.parse(date));
        _repoSCard.save(sCard);


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/issueBooks/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchBook(@RequestParam("value") String value) {
        return new ModelAndView("fragment/option_book", "books", _repoBook.findByNameContainingIgnoreCase(value));
    }
}