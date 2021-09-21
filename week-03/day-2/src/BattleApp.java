import jdk.swing.interop.SwingInterOpUtils;

public class BattleApp {

  public static void main(String[] args) {

    System.out.println("\nBEFORE BATTLE :\n");
    PirateShip ship1 = new PirateShip("ship-1");
    ship1.fillShip();
    System.out.println(ship1);
    PirateShip ship2 = new PirateShip("ship-2");
    ship2.fillShip();
    System.out.println(ship2);

    System.out.println("\nAFTER BATTLE :\n");
    ship1.battle(ship2);
    System.out.println(ship1);
    System.out.println(ship2);

  }
}
