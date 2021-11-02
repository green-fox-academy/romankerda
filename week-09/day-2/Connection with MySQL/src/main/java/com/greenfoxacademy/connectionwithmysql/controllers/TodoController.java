package com.greenfoxacademy.connectionwithmysql.controllers;

import com.greenfoxacademy.connectionwithmysql.models.Todo;
import com.greenfoxacademy.connectionwithmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("todo")
public class TodoController {

  TodoRepository todoRepository;

  @Autowired
  public TodoController(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
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

  @GetMapping(value = "/{Id}/delete")
  public String deleteTodo(@PathVariable (name = "Id") Long id) {
    todoRepository.delete(todoRepository.findById(id).get());
    return "redirect:/todo/list";
  }

  @GetMapping(value = "/{Id}/edit")
  public String editForm(@PathVariable (name = "Id") Long id, Model model) {
    model.addAttribute("todo", todoRepository.findById(id).get());
    return "editForm";
  }

  @PostMapping(value = "/{Id}/edit")
  public String editTodo(@PathVariable Long Id,
                         @RequestParam (required = false) String title,
                         @RequestParam (required = false) boolean urgent,
                         @RequestParam (required = false) boolean done) {
    Todo todo = new Todo(Id, title, urgent, done);
    todoRepository.save(todo);
    return "redirect:/todo/list";
  }
}


