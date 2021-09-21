package PiratesPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Armada {

  private List<PirateShip> fleet;

  public Armada() {
    fleet = new ArrayList<>();
  }

  public void fillArmada() {
    Random rand = new Random();
    int armadaSize = 5 + rand.nextInt(5);
    for (int i = 1; i < armadaSize+1; i++) {
      PirateShip ship = new PirateShip(String.valueOf(i));
      fleet.add(ship);
    }
  }

  public List<PirateShip> getFleet() {
    return fleet;
  }

  public int fightAbleShips() {
    int count = 0;
    for (PirateShip ship : fleet) {
      if (ship.isAbleToFight()) count++;
    }
    return count;
  }

  public boolean war(Armada armada) {
    System.out.println("..... War's begun........\n");
    for (PirateShip ship : this.getFleet()) {
      for (PirateShip shipEnemy : armada.getFleet()) {
        if (ship.isAbleToFight() && shipEnemy.isAbleToFight()) {
          System.out.printf("Army-1 Ship %s vs. Army-2 ship %s", ship.getName(), shipEnemy.getName());
          if (ship.battle(shipEnemy)) System.out.printf(" .... and Army-1 ship %s WON\n", ship.getName());
          else System.out.printf(" .... and Army-2 ship %s WON\n", shipEnemy.getName());
        }
      }
    }
    if (this.fightAbleShips() > armada.fightAbleShips()) {
      return true;
    } else return false;
  }



  @Override
  public String toString() {
    return "PiratesPackage.Armada{" +
            "fleet=" + fleet.size() +
            '}';
  }
}
