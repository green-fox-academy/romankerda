package AircraftCarrierPackage;

import java.util.ArrayList;
import java.util.List;

public class Carrier {

  protected List<Aircraft> aircrafts;
  protected int ammo;
  protected int health;

  public Carrier(int ammo, int health) {
    this.ammo = ammo;
    this.health = health;
    aircrafts = new ArrayList<>();
  }

  public void add(Aircraft aircraft) {
    aircrafts.add(aircraft);
  }

  public void fill() throws NoAmmoException {
    if (ammo == 0) throw new NoAmmoException();
    int remain = 0;
    if (ammoNeeded() > ammo) {
      for (Aircraft a : aircrafts) {
        if (a.isPriority()) {
          remain = a.refillAmmo(ammo);
          ammo = remain;
        }
      }
    } else {
      for (Aircraft a : aircrafts) {
          remain = a.refillAmmo(this.ammo);
          ammo = remain;
      }
    }
  }

    public int ammoNeeded() {
      int ammoNeeded = 0;
      for (Aircraft aircraft : aircrafts) {
        ammoNeeded += aircraft.maxAmmo - aircraft.ammo;
      }
      return ammoNeeded;
    }

    public void fight(Carrier carrier) {
      int damage = 0;
      for (Aircraft a : aircrafts) {
        damage += a.fight();
      }
      carrier.health -= damage;
  }

  public String getStatus() {
    if (health < 0) return "It's dead Jim :-(\n\n";
    int damage = 0;
    for (Aircraft a : aircrafts) {
      damage += a.ammo * a.baseDamage;
    }
    StringBuilder sb = new StringBuilder();
    sb.append("HP: " + health + ", Aircraft count : " + aircrafts.size() + ", Ammo storage: " +
    ammo + ", Total damage: " + damage + "\n" +
            "Aircrafts: \n");
    for (Aircraft a : aircrafts) {
      String status = a.getStatus();
      sb.append(status);
      sb.append("\n");
    }
    return sb.toString();
  }
}
