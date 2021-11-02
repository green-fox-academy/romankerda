package com.greenfoxacademy.connectionwithmysql.repositories;


import com.greenfoxacademy.connectionwithmysql.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

  List<Todo> findAllByDone(boolean done);

}
