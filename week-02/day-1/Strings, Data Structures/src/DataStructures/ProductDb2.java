package DataStructures;

import java.util.HashMap;
import java.util.Map;

public class ProductDb2 {
  public static void main(String[] args) {
    //reate a map with the following key-value pairs:
    //
    //Product name (key)	Price (value)
    //Eggs	200
    //Milk	200
    //Fish	400
    //Apples	150
    //Bread	50
    //Chicken	550
    //Create an application which prints out the answers to the following questions:
    //
    //Which products cost less than 201? (just the name)
    //Which products cost more than 150? (name + price)

    Map<String, Integer> products = new HashMap<>();
    products.put("Eggs", 200);
    products.put("Milk", 200);
    products.put("Fish", 400);
    products.put("Apples", 150);
    products.put("Bread", 50);
    products.put("Chicken", 550);

    Map <String, Integer> less201 = new HashMap<>();
    Map <String, Integer> more150 = new HashMap<>();

    for (String s : products.keySet()) {
      if (products.get(s) < 201) {
        less201.put(s, products.get(s));
      }
      if (products.get(s) > 150) {
        more150.put(s, products.get(s));
      }
    }

    System.out.println("Which products cost less than 201:");
    for (String s : less201.keySet()) {
        System.out.println(s);
    }

    System.out.println("Which products cost more than 150? (name + price):");
    for (String s : more150.keySet()) {
      System.out.printf("%s - %d\n", s, more150.get(s));
    }
  }
}
