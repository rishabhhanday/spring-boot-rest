package com.practice.service;

import com.practice.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculateResultImpl implements CalculateResult {
    private final Logger logger = LoggerFactory.getLogger(CalculateResultImpl.class);

    @Override
    public Student calculateResult(Student student) {
        String result = student.getMarks() > 50 ? "pass" : "fail";
        student.setResult(result);
        logger.info("result of student {} is {}", student.getName(), student.getResult());
        return student;
    }
}
