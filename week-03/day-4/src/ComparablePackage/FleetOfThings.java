package ComparablePackage;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FleetOfThings {

  public static void main(String[] args) {
    Fleet fleet = new Fleet();
    // - You have the `Thing` class
    // - You have the `Fleet` class
    // - You have the `FleetOfThings` class with a `main()` method
    // - Download those, use those
    // - Create a fleet in the main() method

    // - Create a fleet of things to have this output:
    // 1. [ ] Get milk
    // 2. [ ] Remove the obstacles
    // 3. [x] Stand up
    // 4. [x] Eat lunch

    Thing getMilk = new Thing("Get Milk");
    Thing remove = new Thing("Remove the obstacles");
    Thing stand = new Thing("Stand up");
    Thing eat = new Thing("Eat lunch");

    List<Thing> things = new ArrayList<>();
    things.add(getMilk);
    things.add(remove);
    things.add(stand);
    things.add(eat);

    stand.complete();
    eat.complete();

    Collections.sort(things);
    System.out.println(things);

  }
}
