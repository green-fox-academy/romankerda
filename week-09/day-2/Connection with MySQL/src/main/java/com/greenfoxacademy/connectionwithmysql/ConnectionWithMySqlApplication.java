package com.greenfoxacademy.connectionwithmysql;

import com.greenfoxacademy.connectionwithmysql.models.Assignee;
import com.greenfoxacademy.connectionwithmysql.models.Todo;
import com.greenfoxacademy.connectionwithmysql.repositories.AssigneeRepository;
import com.greenfoxacademy.connectionwithmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class ConnectionWithMySqlApplication implements CommandLineRunner {

	TodoRepository todoRepository;
	AssigneeRepository assigneeRepository;

	@Autowired
	public ConnectionWithMySqlApplication(TodoRepository todoRepository, AssigneeRepository assigneeRepository) {
		this.todoRepository = todoRepository;
		this.assigneeRepository = assigneeRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ConnectionWithMySqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Todo todo1 = new Todo("Buy Milk", false, true);
		Todo todo2 = new Todo("Buy Bread", true, false);
		Todo todo3 = new Todo("Walk the dog");
		Todo todo4 = new Todo("Study hard", false, true);
		Todo todo5 = new Todo("Read a book", true, true);
		Todo todo6 = new Todo("Clean bed");
		Todo todo7 = new Todo("Watch TV");
		Todo todo8 = new Todo("Listen to the radio");
		Todo todo9 = new Todo("Go sleep");

		todoRepository.save(todo1);
		todoRepository.save(todo2);
		todoRepository.save(todo3);
		todoRepository.save(todo4);
		todoRepository.save(todo5);
		todoRepository.save(todo6);
		todoRepository.save(todo7);
		todoRepository.save(todo8);
		todoRepository.save(todo9);


		Assignee assignee1 = new Assignee("Roman", "roman@cz");
		Assignee assignee2 = new Assignee("Joe", "joe@com");
		Assignee assignee3 = new Assignee("Olivier", "olivier@fr");



		assigneeRepository.save(assignee1);
		assigneeRepository.save(assignee2);
		assigneeRepository.save(assignee3);

	}
}
