package com.greenfoxacademy.connectionwithmysql.repositories;


import com.greenfoxacademy.connectionwithmysql.models.Assignee;
import com.greenfoxacademy.connectionwithmysql.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

  List<Todo> findAllByDoneIsFalse();

  @Query("SELECT t FROM Todo t WHERE t.description LIKE %?1% OR t.title LIKE %?1%")
  List<Todo> findAllByTitleOrDescriptionLike (String text);

  List<Todo> findAllByDueDate(String date);

  @Query("SELECT t FROM Todo t WHERE t.creationDateString = ?1")
  List<Todo> findAllByCreationDate(String date);

}
