package com.greenfoxacademy.basic_webshop.services;

import com.greenfoxacademy.basic_webshop.models.ShopItem;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ShopItemService {

  private List<ShopItem> list;
  private String currency;

  public ShopItemService() {
    list = new ArrayList(Arrays
            .asList(
                    new ShopItem("Running shoes", "Clothes and shoes", "Nike running shoes for every day sport", 1000, 5),
                    new ShopItem("Printer", "Electronics", "Some HP printer the will rpint pages", 3000, 2),
                    new ShopItem("Coca cola", "Beverages and snacks", "0.5l standard coce", 25, 0),
                    new ShopItem("Wokin", "Beverages and snacks", "Chicken with fried rice adn WOKIN", 119, 100),
                    new ShopItem("T-shirt", "Clothes and shoes", "blue with a corgi on a bike", 300, 1),
                    new ShopItem("Macbook air", "Electronics", "ideal pc for student", 50000, 50),
                    new ShopItem("Tesla", "Electronics", "EV vehicle", 50000, 5),
                    new ShopItem("Tesla with bonus", "Electronics", "EV vehicle + shoes Nike", 110000, 5)
            ));
    currency = "czk";
  }

  public String getCurrency() {
    return currency;
  }

  public List<ShopItem> getAll() {
    return list;
  }

  public List<ShopItem> getOnlyAvailable() {
    return list.stream()
            .filter(i -> i.getQty() > 0)
            .collect(Collectors.toList());
  }

  public List<ShopItem> getCheapestFirst() {
    return list.stream()
            .sorted(Comparator.comparingDouble(ShopItem::getPrice))
            .collect(Collectors.toList());
  }

  public List<ShopItem> getContainsNike() {
    return list.stream()
            .filter(i -> i.getName().toLowerCase().contains("nike") || i.getDescription().toLowerCase().contains("nike"))
            .collect(Collectors.toList());
  }

  public double getAverageStock() {
    OptionalDouble avg = list.stream()
            .mapToLong(i -> i.getQty())
            .average();
    return avg.orElse(-1);
  }

  public List<ShopItem> getMostExpensive() {
    List<ShopItem> listSortedPrice = list.stream()
            .sorted(Comparator.comparing(ShopItem::getPrice).reversed())
            .collect(Collectors.toList());
    List<ShopItem> onlyMax = new ArrayList<>();
    onlyMax.add(listSortedPrice.get(0));
    return onlyMax;
  }

  public List<ShopItem> getSearch(String text) {
    return list.stream()
            .filter(i -> i.getName().toLowerCase().contains(text) || i.getDescription().toLowerCase().contains(text))
            .collect(Collectors.toList());
  }

  public List<ShopItem> getType(String type) {
    return list.stream()
            .filter(i -> i.getType().toLowerCase().contains(type))
            .collect(Collectors.toList());
  }

  public List<ShopItem> getPriceInEur() {
    if (currency.equals("eur")) {
      return list;
    } else {
      for (ShopItem item : list) {
        item.setPrice(item.getPrice() / 25.7);
      }
      currency = "eur";
      return list;
    }
  }

  public List<ShopItem> getPriceInCzk() {
    if (currency.equals("czk")) {
      return list;
    } else {
      for (ShopItem item : list) {
        item.setPrice(item.getPrice() * 25.7);
      }
      currency = "czk";
      return list;
    }
  }
}
