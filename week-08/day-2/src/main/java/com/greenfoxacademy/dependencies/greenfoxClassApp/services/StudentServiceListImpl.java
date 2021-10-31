package com.greenfoxacademy.dependencies.greenfoxClassApp.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceListImpl implements StudentService {
  private List<String> names;


  public StudentServiceListImpl() {
    names = new ArrayList<>();
    names.add("Sanyi");
    names.add("Lilla");
    names.add("John");
  }

  @Override
  public List<String> getStudents() {
    return names;
  }

  @Override
  public void addStudent(String student) {
    names.add(student);
  }

  @Override
  public int getCount() {
    return names.size();
  }

  @Override
  public boolean isOnList(String name) {
    if (names.contains(name)) {
      return true;
    } else return false;
  }
}