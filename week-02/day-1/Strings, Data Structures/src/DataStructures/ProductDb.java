package DataStructures;

import java.util.HashMap;
import java.util.Map;

public class ProductDb {
  public static void main(String[] args) {
    //Create a map with the following key-value pairs:
    //
    //Product name (key)	Price (value)
    //Eggs	200
    //Milk	200
    //Fish	400
    //Apples	150
    //Bread	50
    //Chicken	550

    Map<String, Integer> products= new HashMap<>();
    products.put("Eggs", 200);
    products.put("Milk", 200);
    products.put("Fish", 400);
    products.put("Apples", 150);
    products.put("Bread", 50);
    products.put("Chicken", 550);


    //Create an application which prints out the answers to the following questions:
    //
    //How much is the fish?
    //What is the most expensive product?
    //What is the average price?
    //How many products' price is below 300?
    //Is there anything we can buy for exactly 125?
    //What is the cheapest product?

    System.out.printf("How much is the fish? : %d\n", products.get("Fish"));

    String mostExp = null;
    int max = 0;
    int sum = 0;
    double avg = 0;
    int below = 0;
    boolean for125 = false;
    int min = 99999;
    String cheapest = null;
    for (String s : products.keySet()) {
      if (products.get(s) > max) {
        max = products.get(s);
        mostExp = s;
        sum += products.get(s);
      }
      if (products.get(s) < 300) {
        below++;
      }
      if (products.get(s) == 125) {
        for125 = true;
      }
      avg = sum / products.size();
    }
    for (String s : products.keySet()) {
      if (products.get(s) < min) {
        min = products.get(s);
        cheapest = s;
      }
    }
    System.out.printf("What is the most expensive product? : %s\n", mostExp);
    System.out.printf("What is the maverage price? : %s\n", avg);
    System.out.printf("How many products' price is below 300? : %d\n", below);
    System.out.printf("Is there anything we can buy for exactly 125? : %b\n", for125);
    System.out.printf("What is the cheapest product? : %s\n", cheapest);


  }
}
