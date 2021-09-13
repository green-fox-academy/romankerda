package DataStructures;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ListIntroduction1 {
  public static void main(String[] args) {
    //Create an empty list which will contain names (strings)
    List<String> names = new ArrayList<>();

    //Print out the number of elements in the list
    System.out.println(names.size());

    // Add "William" to the list
    names.add("William");

    //Print out whether the list is empty or not
    System.out.printf("The list is empty is : %b.\n", names.isEmpty());

    //Add "John" to the list
    names.add("John");

    //Add "Amanda" to the list
    names.add("Amanda");

    //Print out the number of elements in the list
    System.out.println(names.size());

    //Print out the 3rd element
    System.out.println(names.get(2));

    //Iterate through the list and print out each name
    //William
    //John
    //Amanda
    for (String s : names) {
      System.out.println(s);
    }

    //Iterate through the list and print
    //1. William
    //2. John
    //3. Amanda
    for (String s : names) {
      System.out.printf("%d. %s\n", names.indexOf(s)+1, s);
    }

    //Remove the 2nd element
    names.remove(1);

    //Iterate through the list in a reversed order and print out each name
    //Amanda
    //William

    for (int i = names.size()-1; i >-1 ; i--) {
      System.out.println(names.get(i));
    }

    //Remove all elements
    names.clear();
  }
}
