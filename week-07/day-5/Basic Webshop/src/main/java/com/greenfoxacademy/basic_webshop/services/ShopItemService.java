package com.greenfoxacademy.basic_webshop.services;

import com.greenfoxacademy.basic_webshop.models.ShopItem;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@Component
public interface ShopItemService {


  public String getCurrency();

  public List<ShopItem> getAll();

  public List<ShopItem> getOnlyAvailable();

  public List<ShopItem> getCheapestFirst();

  public List<ShopItem> getContainsNike();

  public double getAverageStock();

  public List<ShopItem> getMostExpensive();

  public List<ShopItem> getSearch(String text);

  public List<ShopItem> getType(String type);

  public List<ShopItem> getPriceInEur();

  public List<ShopItem> getPriceInCzk();

  public List<ShopItem> getSearchPrice(Double value, String type);
}
