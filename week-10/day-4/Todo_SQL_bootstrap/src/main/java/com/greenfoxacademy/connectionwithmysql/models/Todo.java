package com.greenfoxacademy.connectionwithmysql.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String title;
  private String description;
  private boolean urgent;
  private boolean done;
  @Temporal(TemporalType.DATE)
  private Date creationDate;
  private String dueDate;
  @ManyToOne(fetch = FetchType.LAZY)
  private Assignee assignee;

  public Todo(String title) {
    this.title = title;
    urgent = false;
    done = false;
    creationDate = new Date();
  }

  public Todo(String title, String description, String dueDate) {
    this.title = title;
    this.description = description;
    this.dueDate = dueDate;
    creationDate = new Date();
    urgent = false;
    done = false;
  }

  public Todo(long id, String title, String description, boolean urgent, boolean done, String dueDate, Assignee assignee) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.urgent = urgent;
    this.done = done;
    this.dueDate = dueDate;
    this.assignee = assignee;
  }

  public Todo(String title, boolean urgent, boolean done) {
    this.title = title;
    this.urgent = urgent;
    this.done = done;
    creationDate = new Date();
  }
}
