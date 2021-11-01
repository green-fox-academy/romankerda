package com.greenfoxacademy.dependencies.greenfoxClassApp.controllers;

import com.greenfoxacademy.dependencies.greenfoxClassApp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClassController {

  private StudentService studentService;

  @Autowired
  public ClassController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping(value = "/gfa")
  public String start(Model model) {
    model.addAttribute("counter", studentService.getCount());
    return "indexClass";
  }

  @GetMapping(value = "/gfa/list")
  public String listAll(Model model) {
    model.addAttribute("list", studentService.getStudents());
    return "list";
  }

  @PostMapping(value = "/gfa/save")
  public String addStudent(Model model, @RequestParam("name") String name) {
    studentService.addStudent(name);
    return "redirect:/gfa";
  }

  @GetMapping(value = "/gfa/add")
  public String toToAddPage() {
    return "add";
  }

  @PostMapping(value = "/gfa/check")
  public String checkStudent(Model model, @RequestParam("name") String name) {
    model.addAttribute("isOnList", studentService.isOnList(name));
    model.addAttribute("name", name);
    return "checkResult";
  }

  @GetMapping(value = "/gfa/checkForm")
  public String toCheckForm() {
    return "checkForm";
  }
}
