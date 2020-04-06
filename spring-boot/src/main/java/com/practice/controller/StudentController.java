package com.practice.controller;

import com.practice.dao.StudentDao;
import com.practice.model.Student;
import com.practice.service.CalculateResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
@Slf4j
public class StudentController {
    // private final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private CalculateResult calculateResult;

    @PostMapping(value = "/addStudent")
    public Student addStudent(@RequestBody @Valid Student student) {
        Student studentSavedInDb = studentDao.save(calculateResult.calculateResult(student));
        log.info("Student saved to db {}", studentSavedInDb);
        return studentSavedInDb;
    }

    @GetMapping(value = "/getAllStudent")
    public List<Student> getAllStudent() {
        return studentDao.findAll();
    }

    @ExceptionHandler
    void handleException(Exception exception) {
        log.error("exception raised {}", exception.getMessage());
    }
}
