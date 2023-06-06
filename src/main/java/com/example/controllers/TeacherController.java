package com.example.controllers;

import com.example.domain.dao.IDepartmentRepository;
import com.example.domain.dao.ITeacherRepository;
import com.example.domain.models.Department;
import com.example.domain.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/add")
public class TeacherController {
    @Autowired
    private ITeacherRepository _repo;
    @Autowired
    private IDepartmentRepository _repoDepartment;

    @RequestMapping("/teacherAdd")
    ModelAndView Index() {
        ModelAndView mv= new ModelAndView("teacher/add_teacher", "teachers", _repo.findAll());
        mv.addObject("departments", _repoDepartment.findAll());
        return mv;
    }

    @PostMapping("/teacherAdd")
    public ResponseEntity<Object> TeacherAddPost(@RequestParam String firstName,@RequestParam String lastName, @RequestParam String department) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setDepartment(_repoDepartment.getReferenceById(Long.parseLong(department)));

        _repo.save(teacher);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/department", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView Department() {
        return new ModelAndView("/fragment/option", "obj", _repoDepartment.findAll());
    }
    @PostMapping("/departmentAdd")
    public ResponseEntity<Object> FacultyAddPost(@RequestParam String departmentName) {
        Department department = new Department();
        department.setName(departmentName);

        _repoDepartment.save(department);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
