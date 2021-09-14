package DataStructures;

import java.awt.desktop.AboutEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ShoppingList2 {
  public static void main(String[] args) {
    //Represent the following products with their prices:
    //
    //Product	Price
    //Milk	1.07
    //Rice	1.59
    //Eggs	3.14
    //Cheese	12.60
    //Chicken Breasts	9.40
    //Apples	2.31
    //Tomato	2.58
    //Potato	1.75
    //Onion	1.10
    Map<String, Double> prices = new HashMap<>();
    prices.put("Milk", 1.07);
    prices.put("Rice", 1.59);
    prices.put("Eggs", 3.14);
    prices.put("Cheese", 12.60);
    prices.put("Chicken Breasts", 9.40);
    prices.put("Apples", 2.31);
    prices.put("Tomato", 2.58);
    prices.put("Potato", 1.75);
    prices.put("Onion", 1.10);

    //Represent Bob's shopping list:
    //
    //Product	Amount
    //Milk	3
    //Rice	2
    //Eggs	2
    //Cheese	1
    //Chicken Breasts	4
    //Apples	1
    //Tomato	2
    //Potato	1

    Map<String, Integer> bob = new HashMap<>();
    bob.put("Milk", 3);
    bob.put("Rice", 2);
    bob.put("Eggs", 2);
    bob.put("Cheese", 1);
    bob.put("Chicken Breasts", 4);
    bob.put("Apples", 1);
    bob.put("Tomato", 2);
    bob.put("Potato", 1);

    //Represent Alice's shopping list:
    //
    //Product	Amount
    //Rice	1
    //Eggs	5
    //Chicken Breasts	2
    //Apples	1
    //Tomato	10
    Map<String, Integer> alice = new HashMap<>();
    alice.put("Rice", 1);
    alice.put("Eggs", 5);
    alice.put("Chicken Breasts", 2);
    alice.put("Apples", 1);
    alice.put("Tomato", 10);

    //Create an application which prints out the answers to the following questions:
    //
    //How much does Bob pay?
    //How much does Alice pay?
    //Who buys more Rice?
    //Who buys more Potato?
    //Who buys more different products?
    //Who buys more products? (more pieces)

    double sum = 0;
    double price = 0;
    for (String s : bob.keySet()) {
      sum = sum + bob.get(s).doubleValue() * prices.get(s).doubleValue();
    }
    System.out.printf("How much did Bob pay?: %f\n", sum);

    sum = 0;
    price = 0;
    for (String s : alice.keySet()) {
      sum = sum + alice.get(s).doubleValue() * prices.get(s).doubleValue();
    }
    System.out.printf("How much did Alice pay?: %f\n", sum);

    String name = "";
    String item = "Rice";
    if (bob.get(item) > alice.get(item)) {
      name = "Bob";
    } else name = "Alice";
    System.out.printf("%s buys more %s\n", name, item);


    item = "Potato";
    int bobPot = 0;
    int alicePot = 0;
    if ((bob.get(item)) != null) {
      bobPot = bob.get(item);
    }if ((alice.get(item)) != null) {
      alicePot = alice.get(item);
    }

    if (bobPot > alicePot) {
      name = "Bob";
    } else name = "Alice";
    System.out.printf("%s buys more %s\n", name, item);


    if (bob.size() > alice.size()) {
      System.out.println("Bob buys more different products");
    } else System.out.println("Bob buys more different products");

    int bobPcs = 0;
    int alicePcs = 0;
    for (String s: bob.keySet()) {
      bobPcs += bob.get(s);
      }
    for (String s: alice.keySet()) {
      alicePcs += alice.get(s);
    }
    if (bobPcs > alicePcs) {
      System.out.println("Bob buys more pcs.");
    } else System.out.println("Alice buys more pcs.");
    
  }
}
