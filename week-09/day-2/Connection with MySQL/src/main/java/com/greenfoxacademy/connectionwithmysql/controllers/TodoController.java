package com.greenfoxacademy.connectionwithmysql.controllers;

import com.greenfoxacademy.connectionwithmysql.models.Todo;
import com.greenfoxacademy.connectionwithmysql.repositories.TodoRepository;
import com.greenfoxacademy.connectionwithmysql.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("todo")
public class TodoController {

  TodoService todoService;

  @Autowired
  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping(value = {"/", "/list"})
  public String list(@RequestParam (required = false) boolean isActive, Model model) {
    if (isActive) {
      model.addAttribute("todos", todoService.findActive());
    }
    else {
      model.addAttribute("todos", todoService.findAll());
    }
    return "todolist";
  }

  @GetMapping(value = "/add")
  public String addForm() {
     return "addForm";
  }

  @PostMapping(value = "/add")
  public String addTodo(@RequestParam String title, Model model) {
    todoService.saveTodo(new Todo(title));
    return "redirect:/todo/list";
  }

  @GetMapping(value = "/{Id}/delete")
  public String deleteTodo(@PathVariable (name = "Id") Long id) {
    todoService.deleteTodo(id);
    return "redirect:/todo/list";
  }

  @GetMapping(value = "/{Id}/edit")
  public String editForm(@PathVariable (name = "Id") Long id, Model model) {
    model.addAttribute("todo", todoService.findById(id));
    return "editForm";
  }

  @PostMapping(value = "/{Id}/edit")
  public String editForm(@PathVariable Long Id,
                         @RequestParam (required = false) String title,
                         @RequestParam (required = false) boolean urgent,
                         @RequestParam (required = false) boolean done) {
    Todo todo = new Todo(Id, title, urgent, done);
    todoService.saveTodo(todo);
    return "redirect:/todo/list";
  }
}


