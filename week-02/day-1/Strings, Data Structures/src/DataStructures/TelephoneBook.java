package DataStructures;

import java.sql.SQLOutput;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class TelephoneBook {
  public static void main(String[] args) {
    //Create a map with the following key-value pairs:
    //
    //Name (key)	Phone number (value)
    //William A. Lathan	405-709-1865
    //John K. Miller	402-247-8568
    //Hortensia E. Foster	606-481-6467
    //Amanda D. Newland	319-243-5613
    //Brooke P. Askew	307-687-2982
    //Create an application which prints out the answers to the following questions:
    //
    //What is John K. Miller's phone number?
    //Whose phone number is 307-687-2982?
    //Do we know Chris E. Myers' phone number?

    Map<String, String> phoneBook = Map.of("William A. Lathan", "405-709-1865", "John K. Miller", "402-247-8568",
            "Hortensia E. Foster", "606-481-6467", "Amanda D. Newland", "319-243-5613",
            "Brooke P. Askew", "307-687-2982");

    System.out.printf("John K. Miller's phone nr = %s\n", phoneBook.get("John K. Miller"));

    for (String s : phoneBook.keySet()) {
      if (phoneBook.get(s) == "307-687-2982") {
        System.out.printf("307-687-2982 is phone nr. of %s.\n", s);
      }
    }

    System.out.println(phoneBook.get("Chris E. Myers"));

    boolean answer = !isNull(phoneBook.get("Chris E. Myers"));
    System.out.printf("Do we know  Chris E. Myers' nr?: %b", answer);


  }
}
