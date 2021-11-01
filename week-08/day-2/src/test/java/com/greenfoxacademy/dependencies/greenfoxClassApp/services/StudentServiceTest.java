package com.greenfoxacademy.dependencies.greenfoxClassApp.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

  @Autowired
  StudentService studentService;

  @BeforeEach
  void setup() {
    studentService = new StudentServiceFileImpl();
  }

  @Test
  @DisplayName("shouldCorrectlyAddNewStudent")
  void shouldCorrectlyAddNewStudent() {
    studentService.addStudent("Roman");
    assertEquals("Roman", studentService.getStudents().get(studentService.getCount()-1));
  }

}