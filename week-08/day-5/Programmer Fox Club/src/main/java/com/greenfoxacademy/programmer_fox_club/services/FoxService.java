package com.greenfoxacademy.programmer_fox_club.services;


import com.greenfoxacademy.programmer_fox_club.models.Fox;
import com.greenfoxacademy.programmer_fox_club.models.Trick;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FoxService {

  private List<Fox> foxList;


  public FoxService() {
    foxList = new ArrayList<>();
  }

  public boolean add(String name) {
    if (!isFoxInList(name)) {
      foxList.add(new Fox(name));
      return true;
    }
    return false;
  }

  public Fox findActualFox(String name) {
    if (isFoxInList(name)) {
      List<Fox> foxes = foxList.stream()
              .filter(f -> f.getName().equals(name))
              .collect(Collectors.toList());
      return foxes.get(0);
    }
    add(name);
    return foxList.get(foxList.size() - 1);
  }

  public boolean isFoxInList(String name) {
    if (foxList.isEmpty()) {
      return false;
    } else {
      List<String> foxes = foxList.stream()
              .map(f -> f.getName())
              .collect(Collectors.toList());
      return foxes.contains(name) ? true : false;
    }
  }

  public void addTrick(String name, String trick) {
    Fox actualFox = findActualFox(name);
    actualFox.getTricks().add(Trick.valueOf(trick));
  }

  public List<Trick> getTricksToLearn(String name) {
    Fox actualFox = findActualFox(name);
    List<Trick> tricksToLearn = new ArrayList<>();
    tricksToLearn.addAll(Arrays.asList(Trick.values()));
    for (Trick trick : actualFox.getTricks()) {
      tricksToLearn.remove(trick);
    }
    return tricksToLearn;
  }
}
