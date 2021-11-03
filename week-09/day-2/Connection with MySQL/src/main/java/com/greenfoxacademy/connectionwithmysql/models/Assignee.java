package com.greenfoxacademy.connectionwithmysql.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
  @OneToMany(cascade = CascadeType.ALL)
//  @JoinColumn(name = "todo_id", referencedColumnName = "id")
  private List<Todo> todos;

  public Assignee(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public Assignee(Long id, String name, String email) {
    this.name = name;
    this.email = email;
  }

  public String toString(){
    return String.format("%s, %s", name, email);
  }

  public void addTodo(Todo todo) {
    todos.add(todo);
  }


}
