package FleetOfThingsPackage;

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

    fleet.add(getMilk);
    fleet.add(remove);
    fleet.add(stand);
    fleet.add(eat);

    stand.complete();
    eat.complete();

    System.out.println(fleet);
  }
}
