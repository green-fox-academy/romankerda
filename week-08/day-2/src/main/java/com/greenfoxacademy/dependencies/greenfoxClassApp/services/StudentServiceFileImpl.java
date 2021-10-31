package com.greenfoxacademy.dependencies.greenfoxClassApp.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceFileImpl implements StudentService{

  private String path = "src/main/resources/templates/names.txt";


  @Override
  public List<String> getStudents() {
    return readNames();
  }

  public List<String> readNames() {
    try {
      List<String> students = Files.readAllLines(Paths.get(path));
      return students;
    } catch (IOException e) {
      System.err.println("Can't read file names.txt");
    }
    return new ArrayList<>();
  }

  public void writeNames(List<String> students) {
    try {
      Files.write(Paths.get(path), students);
    } catch (IOException e) {
      System.err.println("Can't write file names.txt");
    }
  }

  @Override
  public void addStudent(String student) {
    List<String> students = readNames();
    students.add(student);
    writeNames(students);
  }

  @Override
  public int getCount() {
    return readNames().size();
  }

  @Override
  public boolean isOnList(String name) {
    return readNames().contains(name) ? true : false;
  }
}
