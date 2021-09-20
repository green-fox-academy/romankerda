package ParkingLotPackage;

import java.util.*;

public class Main {
  public static void main(String[] args) {

    Random random = new Random();
    List<Car> cars = new ArrayList<>();
    for (int i = 0; i <256; i++) {
      int randomTypeNr = (int) (Math.random() * Car.Type.values().length);
      int randomColorNr = (int) (Math.random() * Car.Color.values().length);
      cars.add(new Car(Car.Type.values()[randomTypeNr], Car.Color.values()[randomColorNr]));
    }

    Map<Car.Type, Integer> carsMapType = new HashMap<>();
    for (Car car : cars) {
      if (!carsMapType.keySet().contains(car.type)) {
        carsMapType.put(car.type, 1);
      } else
        carsMapType.put(car.type, carsMapType.get(car.type)+1);
    }

    Map<Car.Color, Integer> carsMapColor = new HashMap<>();
    for (Car car : cars) {
      if (!carsMapColor.keySet().contains(car.color)) {
        carsMapColor.put(car.color, 1);
      } else
        carsMapColor.put(car.color, carsMapColor.get(car.color)+1);
    }
    System.out.println(carsMapType);
    System.out.println(carsMapColor);
  }
}
