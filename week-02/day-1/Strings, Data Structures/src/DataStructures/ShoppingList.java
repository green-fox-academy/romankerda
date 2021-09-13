package DataStructures;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingList {
  public static void main(String[] args) {
    //Create a list with the following items:
    //ˇ"eggs", "milk", "fish", "apples", "bread" and "chicken"
    //Create an application which prints out the answers to the following questions:
    //Do we have milk on the list?
    //Do we have bananas on the list?

    List<String> shoppingList = new ArrayList<>();
    Collections.addAll(shoppingList, "eggs", "milk", "fish", "apples", "bread","chicken" );
    boolean isMilk = shoppingList.contains("milk");
    boolean isBananas = shoppingList.contains("bananas");
    System.out.printf("Do we have milk on the list? : %b\n", isMilk);
    System.out.printf("Do we have bananas on the list? : %b\n", isBananas);
  }
}
