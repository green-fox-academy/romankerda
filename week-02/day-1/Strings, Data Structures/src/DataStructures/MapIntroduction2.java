package DataStructures;

import java.util.HashMap;
import java.util.Map;

public class MapIntroduction2 {
  public static void main(String[] args) {
    //Create a map where the keys are strings and the values are strings with the following initial values
    //
    //Key	Value
    //978-1-60309-452-8	A Letter to Jo
    //978-1-60309-459-7	Lupus
    //978-1-60309-444-3	Red Panda and Moon Bear
    //978-1-60309-461-0	The Lab

    Map<String, String> books = new HashMap<>();
    books.put("978-1-60309-452-8", "A Letter to Jo");
    books.put("978-1-60309-459-7", "Lupus");
    books.put("978-1-60309-444-3", "Red Panda and Moon Bear");
    books.put("978-1-60309-461-0", "The Lab");

    //Print all the key-value pairs in the following format
    //
    //A Letter to Jo (ISBN: 978-1-60309-452-8)
    //Lupus (ISBN: 978-1-60309-459-7)
    //Red Panda and Moon Bear (ISBN: 978-1-60309-444-3)
    //The Lab (ISBN: 978-1-60309-461-0)

    for (Map.Entry<String, String> pair : books.entrySet()) {
      System.out.printf("%s (ISBN: %s)\n", pair.getValue(), pair.getKey());
    }

    //Remove the key-value pair with key 978-1-60309-444-3
    books.remove("978-1-60309-444-3");

    //Remove the key-value pair with value The Lab
    for (String s: books.keySet()) {
      if (books.get(s) == "The Lab") {
        books.remove(s);
      }
    }
    System.out.println();

    //Add the following key-value pairs to the map
    //Key	Value
    //978-1-60309-450-4	They Called Us Enemy
    //978-1-60309-453-5	Why Did We Trust Him?
    books.put("978-1-60309-450-4", "They Called Us Enemy");
    books.put("978-1-60309-453-5", "Why Did We Trust Him");

    //Print whether there is an associated value with key 478-0-61159-424-8 or not
    System.out.println(books.get("478-0-61159-424-8"));
    System.out.println();


    //Print the value associated with key 978-1-60309-453-5
    System.out.println(books.get("978-1-60309-453-5"));
  }
}
