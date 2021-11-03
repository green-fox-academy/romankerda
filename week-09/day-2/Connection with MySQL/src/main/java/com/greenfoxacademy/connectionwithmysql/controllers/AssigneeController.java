package com.greenfoxacademy.connectionwithmysql.controllers;

import com.greenfoxacademy.connectionwithmysql.models.Assignee;
import com.greenfoxacademy.connectionwithmysql.models.Todo;
import com.greenfoxacademy.connectionwithmysql.repositories.AssigneeRepository;
import com.greenfoxacademy.connectionwithmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/assignee")
public class AssigneeController {

  AssigneeRepository assigneeRepository;
  TodoRepository todoRepository;

  @Autowired
  public AssigneeController(AssigneeRepository assigneeRepository, TodoRepository todoRepository) {
    this.assigneeRepository = assigneeRepository;
    this.todoRepository = todoRepository;
  }

  @GetMapping(value = "")
  public String listAll(Model model) {
    model.addAttribute("assignees", assigneeRepository.findAll());
    return "assigneeList";
  }

  @GetMapping(value = "/add")
  public String addForm() {
    return "addFormAssignee";
  }

  @PostMapping(value = "/add")
  public String addForm(@RequestParam String name, @RequestParam String email) {
    assigneeRepository.save(new Assignee(name, email));
    return "redirect:/assignee";
  }

  @GetMapping(value = "/{id}/delete")
  public String deleteTodo(@PathVariable(name = "id") Long id) {
    List<Todo> todos = todoRepository.findAllByAssigneeId(id);
    todos.forEach(todo -> todo.setAssignee(new Assignee()));
    todos.forEach(todo -> todoRepository.save(todo));
    assigneeRepository.delete(assigneeRepository.findById(id).get());
    return "redirect:/assignee";
  }

  @GetMapping(value = "/{id}/edit")
  public String editForm(@PathVariable Long id, Model model) {
    model.addAttribute("assignee", assigneeRepository.findById(id).get());
    return "editFormAssignee";
  }

  @PostMapping(value = "/{id}/edit")
  public String editTodo(@PathVariable Long id,
                         @RequestParam (required = false) String name,
                         @RequestParam (required = false) String email) {
    Assignee assignee = assigneeRepository.findById(id).get();
    assignee.setName(name);
    assignee.setEmail(email);
    assigneeRepository.save(assignee);
    return "redirect:/assignee";
  }
}
