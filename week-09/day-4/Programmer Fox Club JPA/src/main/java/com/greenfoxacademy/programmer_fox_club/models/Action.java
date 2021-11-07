package com.greenfoxacademy.programmer_fox_club.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Time;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Action {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Temporal(TemporalType.TIMESTAMP)
  private Date date;
  private String description;
  @ManyToOne(fetch = FetchType.LAZY)
  private Fox fox;

  public Action (Fox fox, String description) {
    this.description = description;
    this.fox = fox;
//    date = new Date();
  }

  // TODO: 07.11.2021 change Date() to timestamp, currently not showing time, 

}
