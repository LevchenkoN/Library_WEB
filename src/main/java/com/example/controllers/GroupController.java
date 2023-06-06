package com.example.controllers;

import com.example.domain.dao.IFacultyRepository;
import com.example.domain.dao.IGroupRepository;
import com.example.domain.models.Faculty;
import com.example.domain.models.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/add")
public class GroupController {
    @Autowired
    private IGroupRepository _repo;
    @Autowired
    private IFacultyRepository _repoFaculty;

    @RequestMapping("/groupAdd")
    ModelAndView Index() {
        ModelAndView mv= new ModelAndView("group/add_group", "groups", _repo.findAll());
        mv.addObject("faculties", _repoFaculty.findAll());
        return mv;
    }

    @PostMapping("/groupAdd")
    public ResponseEntity<Object> GroupAddPost(@RequestParam String groupName, @RequestParam String faculty) {
        Group group = new Group();
        group.setName(groupName);
        group.setFaculty(_repoFaculty.getReferenceById(Long.parseLong(faculty)));

        _repo.save(group);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/faculties", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchBook() {
        return new ModelAndView("/fragment/option", "obj", _repoFaculty.findAll());
    }
    @PostMapping("/facultyAdd")
    public ResponseEntity<Object> FacultyAddPost(@RequestParam String facultyName) {
        Faculty faculty = new Faculty();
        faculty.setName(facultyName);

        _repoFaculty.save(faculty);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
