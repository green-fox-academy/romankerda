package com.greenfoxacademy.connectionwithmysql;

import com.greenfoxacademy.connectionwithmysql.models.Todo;
import com.greenfoxacademy.connectionwithmysql.repositories.TodoRepository;
import com.greenfoxacademy.connectionwithmysql.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class ConnectionWithMySqlApplication implements CommandLineRunner {

	TodoService todoService;

	@Autowired
	public ConnectionWithMySqlApplication(TodoService todoService) {
		this.todoService = todoService;
	}
	public static void main(String[] args) {
		SpringApplication.run(ConnectionWithMySqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		todoService.save(new Todo("Buy Milk", false, true));
//		todoService.save(new Todo("Buy Bread", true, false));
//		todoService.save(new Todo("Walk the dog"));
//		todoService.save(new Todo("Study hard", false, true));
//		todoService.save(new Todo("Read a book", true, true));
//		todoService.save(new Todo("Clean bed"));
//		todoService.save(new Todo("Watch TV"));
//		todoService.save(new Todo("Listen to the radio"));
//		todoService.save(new Todo("Go sleep"));

//		todoService.deleteTodo(4l);




	}
}
