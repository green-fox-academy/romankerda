package PetrolStationPackage;

public class Station {

  int gasAmount;

  public void refill(Car car) {
    this.gasAmount -= car.capacity;
    car.gasAmount += car.capacity;
  }

  @Override
  public String toString() {
    return "Station{" +
            "gasAmount=" + gasAmount +
            '}';
  }
}
