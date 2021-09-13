package DataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListIntroduction2 {
  public static void main(String[] args) {
    //Create a list ('List A') which contains the following values
    //Apple, Avocado, Blueberries, Durian, Lychee
    List<String> listA = new ArrayList<>();
    listA.add("Apple");
    listA.add("Avocado");
    listA.add("Blueberries");
    listA.add("Durian");
    listA.add("Lychee");

    //Create a new list ('List B') with the values of List A
    List<String> listB = new ArrayList<>();
    for (int i = 0; i < listA.size(); i++) {
      listB.add(listA.get(i));
    }

    //Print out whether List A contains "Durian" or not
    System.out.println(listA.contains("Durian"));
    System.out.println();

    //Remove "Durian" from List B
    listB.remove("Durian");
    //Add "Kiwifruit" to List A after the 4th element
    listA.add(4, "Kiwifruit");
    for (String s: listB) {
      System.out.println(s);
    }
    System.out.println();

    //Compare the size of List A and List B
    int sizeDiff = listA.size() - listB.size();
    System.out.printf("Size difference between listA & listB = %d\n", sizeDiff);
    System.out.println();

    //Get the index of "Avocado" from List A
    System.out.println(listA.indexOf("Avocado"));
    System.out.println();

    //Get the index of "Durian" from List B
    System.out.println(listB.indexOf("Durian"));
    System.out.println();

    //Add "Passion Fruit" and "Pomelo" to List B in a single statement
    Collections.addAll(listB, "Passion Fruit", "Pomelo");

    //Print out the 3rd element from List A
    System.out.println(listA.get(2));
  }
}
