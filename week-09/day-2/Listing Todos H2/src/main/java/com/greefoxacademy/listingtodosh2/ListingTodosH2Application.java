package com.greefoxacademy.listingtodosh2;

import com.greefoxacademy.listingtodosh2.models.Todo;
import com.greefoxacademy.listingtodosh2.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListingTodosH2Application implements CommandLineRunner {

  TodoRepository todoRepository;

  @Autowired
  public ListingTodosH2Application(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(ListingTodosH2Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    todoRepository.save(new Todo("Buy milk"));
    todoRepository.save(new Todo("Buy more milk"));
    todoRepository.save(new Todo("Do homework"));
    todoRepository.save(new Todo("Each lunch"));
    System.out.println("done");

  }
}
