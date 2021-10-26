package com.greenfoxacademy.dependencies.greenfoxClassApp.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
  private List<String> names;

  public StudentService() {
    names = new ArrayList<>();
    names.add("Sanyi");
    names.add("Lilla");
    names.add("John");
  }


  public List<String> findAll() {
    return names;
  }

  public void save(String student) {
    names.add(student);
  }

  public int getCount() {
    return names.size();
  }

  public boolean checkIsOnList(String name) {
    if (names.contains(name)) {
      return true;
    } else return false;
  }
}