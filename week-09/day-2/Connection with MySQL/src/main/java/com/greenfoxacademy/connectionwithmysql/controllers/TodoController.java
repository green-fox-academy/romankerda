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
@RequestMapping("todo")
public class TodoController {

  private TodoRepository todoRepository;
  private AssigneeRepository assigneeRepository;

  @Autowired
  public TodoController(TodoRepository todoRepository, AssigneeRepository assigneeRepository) {
    this.todoRepository = todoRepository;
    this.assigneeRepository = assigneeRepository;
  }

  @GetMapping(value = {"/", "/list"})
  public String list(@RequestParam (required = false) boolean isActive, Model model) {
    if (isActive) {
      model.addAttribute("todos", todoRepository.findAllByDoneIsFalse());
    }
    else {
      model.addAttribute("todos", todoRepository.findAll());
    }
    return "todolist";
  }

  @GetMapping(value = "/add")
  public String addForm() {
     return "addForm";
  }

  @PostMapping(value = "/add")
  public String addTodo(@RequestParam String title, Model model) {
    todoRepository.save(new Todo(title));
    return "redirect:/todo/list";
  }

  @GetMapping(value = "/{id}/delete")
  public String deleteTodo(@PathVariable Long id) {
    todoRepository.delete(todoRepository.findById(id).get());
    return "redirect:/todo/list";
  }

  @GetMapping(value = "/{id}/edit")
  public String editForm(@PathVariable Long id, Model model) {
    model.addAttribute("todo", todoRepository.findById(id).get());
    model.addAttribute("assignees", assigneeRepository.findAll());
    return "editForm";
  }

  @PostMapping(value = "/{id}/edit")
  public String editTodo(@PathVariable Long id,
                         @RequestParam (required = false) String title,
                         @RequestParam (required = false) Long assigneeId,
                         @RequestParam (required = false) boolean urgent,
                         @RequestParam (required = false) boolean done) {
    Todo todo = new Todo(id, title, urgent, done, assigneeRepository.findById(assigneeId).get());
    todoRepository.save(todo);
    assigneeRepository.findById(assigneeId).get().addTodo(todo);
    return "redirect:/todo/list";
  }

  @PostMapping(value = "/search")
  public String search(@RequestParam String search, Model model) {
      model.addAttribute("todos", todoRepository.findAllByTitleContaining(search));
    return "todolist";

  }
}


