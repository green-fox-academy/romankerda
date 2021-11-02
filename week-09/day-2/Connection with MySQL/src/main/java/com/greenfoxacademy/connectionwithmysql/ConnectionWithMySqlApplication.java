package com.greenfoxacademy.connectionwithmysql;

import com.greenfoxacademy.connectionwithmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class ConnectionWithMySqlApplication implements CommandLineRunner {

	TodoRepository todoRepository;

	@Autowired
	public ConnectionWithMySqlApplication(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(ConnectionWithMySqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		todoRepository.save(new Todo("Buy Milk", false, true));
//		todoRepository.save(new Todo("Buy Bread", true, false));
//		todoRepository.save(new Todo("Walk the dog"));
//		todoRepository.save(new Todo("Study hard", false, true));
//		todoRepository.save(new Todo("Read a book", true, true));
//		todoRepository.save(new Todo("Clean bed"));
//		todoRepository.save(new Todo("Watch TV"));
//		todoRepository.save(new Todo("Listen to the radio"));
//		todoRepository.save(new Todo("Go sleep"));

//




	}
}
