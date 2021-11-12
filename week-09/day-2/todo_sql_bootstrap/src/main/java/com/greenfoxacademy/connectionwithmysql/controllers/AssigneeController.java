package com.greenfoxacademy.connectionwithmysql.controllers;

import com.greenfoxacademy.connectionwithmysql.models.Assignee;
import com.greenfoxacademy.connectionwithmysql.models.Todo;
import com.greenfoxacademy.connectionwithmysql.repositories.AssigneeRepository;
import com.greenfoxacademy.connectionwithmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
    Assignee assignee = assigneeRepository.findById(id).get();
    assigneeRepository.delete(assignee);
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

  @GetMapping(value = "/{id}/todos")
  public String todosByAssignee(@PathVariable Long id, Model model) {
    model.addAttribute("todos", assigneeRepository.findById(id).get().getTodos());
    return "todolist";
  }

  @GetMapping(value = "/{id}/todos2")     //id = todo.id
  public String todosByAssignee2(@PathVariable Long id, Model model) {
    //find assignee.id by todo.id
    Long assigneeId = todoRepository.getById(id).getAssignee().getId();
    //get todos by assignee.id
    model.addAttribute("todos", assigneeRepository.findById(assigneeId).get().getTodos());
    return "todolist";
  }
}
