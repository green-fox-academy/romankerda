package com.greefoxacademy.listingtodosh2.repositories;

import com.greefoxacademy.listingtodosh2.models.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {


}
