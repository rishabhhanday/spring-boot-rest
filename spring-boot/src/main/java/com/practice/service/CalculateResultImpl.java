package com.practice.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateResultImpl implements CalculateResult {

  @Override
  public String calculateResult(int marks) {
    return marks > 50 ? "Pass" : "Fail";
  }
}
