package com.practice.dao;

import com.practice.model.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<StudentInfo, Long> {

}
