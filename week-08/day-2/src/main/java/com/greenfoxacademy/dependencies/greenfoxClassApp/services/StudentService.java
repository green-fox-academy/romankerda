package com.greenfoxacademy.dependencies.greenfoxClassApp.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

  List<String> getStudents();

  void addStudent(String student);

  int getCount();

  boolean isOnList(String name);
}