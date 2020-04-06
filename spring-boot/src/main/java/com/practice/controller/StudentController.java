package com.practice.controller;

import com.practice.model.Student;
import com.practice.service.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentDao studentDao;

    @PostMapping(value = "/addStudent")
    public Student addStudent(@RequestBody Student student) {
        studentDao.save(student);
        return student;
    }

    @GetMapping(value = "/getAllStudent")
    public List<Student> getAllStudent() {
        return studentDao.findAll();
    }

}
