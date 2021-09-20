package PetrolStationPackage;

public class Main {
  public static void main(String[] args) {

    Car car = new Car();
    Station station = new Station();

    System.out.println(car);
    System.out.println(station);

    System.out.println("Car goes to Station to get refilled");
    station.refill(car);

    System.out.println(car);
    System.out.println(station);
  }
}
