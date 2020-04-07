package com.practice.model;

import com.practice.validation.ValidEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Student {
    @Id
    @NotNull
    private long rollNo;
    private String name;
    @Min(0)
    @Max(100)
    private int marks;
    private String result;
    @NotNull
    @ValidEnum
    private School school;
}
