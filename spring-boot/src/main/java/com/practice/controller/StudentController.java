package com.practice.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.practice.dao.StudentDao;
import com.practice.model.StudentInfo;
import com.practice.service.CalculateResult;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/student")
@Slf4j
public class StudentController {

  @Autowired
  private StudentDao studentDao;
  @Autowired
  private CalculateResult calculateResult;

  @PostMapping(value = "/addStudent")
  public StudentInfo addStudent(@RequestBody StudentInfo student) {
    StudentInfo studentInfo = studentDao.save(student);

    return student.add(
        linkTo(methodOn(StudentController.class).getAllStudent()).withSelfRel(),
        linkTo(methodOn(StudentController.class).getResult(student.getRollNo()))
            .withRel("get result")
    );
  }

  @GetMapping(value = "/{rollNo}")
  public StudentInfo getStudentDetails(@PathVariable long rollNo) {
    return studentDao.findById(rollNo).orElse(null);
  }

  @GetMapping("/getResult")
  public Object getResult(@RequestParam(value = "rollNo") long rollNo) {
    return studentDao.findById(rollNo)
        .map(s -> calculateResult.calculateResult(s.getMarks()))
        .orElse("Student not found");
  }

  @GetMapping(value = "/allStudent")
  public List<StudentInfo> getAllStudent() {
    return studentDao.findAll().stream().map(student ->
        student.add(
            linkTo(methodOn(StudentController.class).getAllStudent()).withSelfRel(),
            linkTo(methodOn(StudentController.class).getResult(student.getRollNo()))
                .withRel("get result")
        )).collect(Collectors.toList());
  }
}
