package com.greenfoxacademy.connectionwithmysql.services;

import com.greenfoxacademy.connectionwithmysql.models.Todo;
import com.greenfoxacademy.connectionwithmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

  TodoRepository todoRepository;

  @Autowired
  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public List<Todo> findAll() {
    return (List)todoRepository.findAll();
  }

  public List<Todo> findActive() {
    return todoRepository.findAllByDone(false);
  }

  public void saveTodo(Todo todo) {
    todoRepository.save(todo);
  }

  public void deleteTodo(Long id) {
    todoRepository.deleteById(id);
  }

  public Todo findById(Long id) {
    return todoRepository.findById(id).get();
  }
}

