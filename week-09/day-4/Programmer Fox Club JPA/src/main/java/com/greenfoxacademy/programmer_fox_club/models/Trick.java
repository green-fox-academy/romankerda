package com.greenfoxacademy.programmer_fox_club.models;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
public class Trick {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Enumerated(EnumType.STRING)
  private TrickEnum trickEnum;
  @ManyToOne(fetch = FetchType.LAZY)
  private Fox fox;
}
