import jdk.swing.interop.SwingInterOpUtils;

public class WarApp {
  public static void main(String[] args) {

    Armada armada1 = new Armada();
    armada1.fillArmada();
    Armada armada2 = new Armada();
    armada2.fillArmada();
    System.out.println(armada1);
    System.out.println(armada2 + "\n");


    // fill armadas' ships
    for (PirateShip ship : armada1.getFleet()) {
      ship.fillShip();
    }
    for (PirateShip ship : armada2.getFleet()) {
      ship.fillShip();
    }

    if (armada1.war(armada2)) {
      System.out.println("\n.....Armada1 WON..... \n");
    } else System.out.println("\n.....Armada2 WON.....\n");

    for (PirateShip ship : armada1.getFleet()) {
      System.out.println(ship);
    }
    System.out.println();
    for (PirateShip ship : armada2.getFleet()) {
      System.out.println(ship);
    }
  }
}
