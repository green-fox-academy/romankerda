package com.greenfoxacademy.basic_webshop.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopItem {

  private String name;
  private String type;
  private String description;
  private double price;
  private int qty;


}
