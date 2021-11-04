package com.greenfoxacademy.connectionwithmysql.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Assignee {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  @OneToMany(mappedBy = "assignee", cascade = CascadeType.ALL)
  private List<Todo> todos;

  public Assignee(String name, String email) {
    this.name = name;
    this.email = email;
    todos = new ArrayList<>();
  }

  public String toString(){
    return String.format("%s", name);
  }


  public void addTodo(Todo todo) {
    todos.add(todo);
  }


}
