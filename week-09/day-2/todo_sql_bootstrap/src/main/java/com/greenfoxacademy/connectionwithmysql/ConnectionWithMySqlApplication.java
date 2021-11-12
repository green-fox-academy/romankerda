package com.greenfoxacademy.connectionwithmysql;

import com.greenfoxacademy.connectionwithmysql.models.Assignee;
import com.greenfoxacademy.connectionwithmysql.models.Todo;
import com.greenfoxacademy.connectionwithmysql.repositories.AssigneeRepository;
import com.greenfoxacademy.connectionwithmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


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

//		Todo todo1 = new Todo("Buy Milk", false, true);
//		Todo todo2 = new Todo("Buy Bread", true, false);
//		Todo todo3 = new Todo("Walk the dog");
//
//		Assignee assignee1 = new Assignee("Roman", "roman@cz");
//		Assignee assignee2 = new Assignee("Pepa", "pepa@cz");
//
//		todo1.setAssignee(assignee1);
//		todo2.setAssignee(assignee1);
//		todo3.setAssignee(assignee2);
//		assignee1.setTodos(Arrays.asList(todo1, todo2));
//		assignee2.setTodos(Arrays.asList(todo3));
//
//		assigneeRepository.save(assignee1);
//		assigneeRepository.save(assignee2);

	}
}
