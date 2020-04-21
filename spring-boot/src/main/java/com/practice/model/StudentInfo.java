package com.practice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Data
public class StudentInfo extends RepresentationModel<StudentInfo> {

  @Id
  private long rollNo;
  private String name;
  private int marks;

}
