package com.practice.validation;

import com.practice.model.School;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidEnumValidation implements ConstraintValidator<ValidEnum, School> {
    @Override
    public boolean isValid(School school, ConstraintValidatorContext context) {
        return !school.getSchoolName().equals(School.INVALID.getSchoolName());
    }
}
