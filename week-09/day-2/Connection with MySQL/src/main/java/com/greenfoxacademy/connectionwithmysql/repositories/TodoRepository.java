package com.greenfoxacademy.connectionwithmysql.repositories;


import com.greenfoxacademy.connectionwithmysql.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

  List<Todo> findAllByDoneIsFalse();

  List<Todo> findAllByTitleContaining(String text);

  List<Todo> findAllByAssigneeId(Long id);

}
