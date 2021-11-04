package com.greenfoxacademy.programmer_fox_club.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
  @Temporal(TemporalType.DATE)
  private Date date;
  private String description;
  @ManyToOne(fetch = FetchType.LAZY)
  private Fox fox;

}
