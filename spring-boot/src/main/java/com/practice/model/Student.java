package com.practice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Student {
    @Id
    private long rollNo;
    private String name;
    private int marks;
}
