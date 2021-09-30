package PetrolStationPackage;

public class Car {

  int gasAmount;
  int capacity;

  public Car() {
    this(0, 100);
  }

  public Car(int gasAmount, int capacity) {
    this.gasAmount = gasAmount;
    this.capacity = capacity;
  }

  @Override
  public String toString() {
    return String.format("Car{gasAmount = %d, capacity = %d}", gasAmount, capacity);
  }
}

