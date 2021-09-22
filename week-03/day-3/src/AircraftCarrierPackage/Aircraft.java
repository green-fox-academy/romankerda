package AircraftCarrierPackage;

public class Aircraft {

  public enum Type {F16, F35}

  protected Type type;
  protected int maxAmmo;
  protected int baseDamage;
  protected int ammo;


  public Aircraft() {
    ammo = 0;
  }

  public int fight() {
    int damage = ammo * baseDamage;
    ammo = 0;
    return damage;
  }

  public int refillAmmo(int ammo) {
    if (ammo - maxAmmo > maxAmmo - this.ammo) {
      int ammoBeforeFill = this.ammo;
      this.setAmmo(maxAmmo);
      return ammo - maxAmmo - ammoBeforeFill;
    } else {
      this.ammo += ammo;
      return 0;
    }
  }

  public String getType() {
    return type.toString();
  }

  public String getStatus() {
    return "Type " + type + ", Ammo: " + this.ammo + ", Base Damage: " + baseDamage + ", All Damage: " +
            ammo * baseDamage;
  }

  public boolean isPriority() {
    return type == Type.F35 ? true : false;
  }

  public void setAmmo(int ammo) {
    this.ammo = ammo;
  }
}

