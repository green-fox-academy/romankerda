package PiratesPackage;

import java.util.ArrayList;
import java.util.List;

public class PirateShip {

  private String name;
  private List<Pirate> crew;
  private Pirate captain = null;
  private boolean ableToFight;

  public PirateShip(String name) {
    this.name = name;
    crew = new ArrayList<>();
    ableToFight = true;
  }

  public String getName() {
    return name;
  }

  public boolean isAbleToFight() {
    return ableToFight;
  }

  public void fillShip() {
      captain = new Pirate("captain");
      crew.add(captain);
      int shipCrew = (int) (Math.random() * 113 + 1);
    for (int i = 1; i < shipCrew+1; i++) {
      Pirate pirate = new Pirate(String.valueOf(i));
      crew.add(pirate);
    }
  }

  private int countAlive() {
    int count = 0;
    for (Pirate pirate : crew) {
      if (pirate.getStatus() == Pirate.Status.ALIVE) count ++;
    }
    return count;
  }

  public int score() {
    return countAlive() - captain.getIntoxication();
  }

  public void party() {
    for (Pirate pirate : crew) {
      int rums = (int) (Math.random() * 10 + 1);
      for (int i = 0; i < rums; i++) {
        pirate.drinkSomeRum();
      }
    }
  }

  public boolean battle(PirateShip pirateShip) {
    if (this.score() > pirateShip.score()) {
      int loses = (int) (Math.random() * pirateShip.countAlive() + 1);
      for (int i = 0; i < loses; i++) {
        if (loses > 0) {
          if (pirateShip.crew.get(i).getStatus() == Pirate.Status.ALIVE ) {
            pirateShip.crew.get(i).setStatus(Pirate.Status.DEAD);
            loses--;
          }
        }
      }
      this.party();
      pirateShip.ableToFight = false;
      return true;
    } else {
      int loses = (int) (Math.random() * this.countAlive() + 1);
      for (int i = 0; i < loses; i++) {
        if (loses > 0) {
          if (this.crew.get(i).getStatus() == Pirate.Status.ALIVE) {
            this.crew.get(i).setStatus(Pirate.Status.DEAD);
            loses--;
          }
        }
      }
      pirateShip.party();
      this.ableToFight = false;
      return false;
    }
  }

  @Override
  public String toString() {
    return "PiratesPackage.Pirate Ship " +
            getName().toUpperCase() +
            " { " +
            "Captain is " +
            captain.getStatus() +
            " and drank " +
            captain.getIntoxication() +
            " rums so far. " +
            "Crew = " + this.countAlive() +
            " pirates (score: " +
            score() +
            " ) }";
  }
}
