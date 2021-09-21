package ParkingLotPackage;

import java.util.*;

public class Main {
  public static void main(String[] args) {

//Create 256 random cars:
    Random random = new Random();
    List<Car> cars = new ArrayList<>();
    for (int i = 0; i <256; i++) {
      int randomTypeNr = (int) (Math.random() * Car.Type.values().length);
      int randomColorNr = (int) (Math.random() * Car.Color.values().length);
      cars.add(new Car(Car.Type.values()[randomTypeNr], Car.Color.values()[randomColorNr]));
    }

// Crete HashMap Car Type - nr. of cars:
    Map<Car.Type, Integer> carsMapType = new HashMap<>();
    for (Car car : cars) {
      if (!carsMapType.keySet().contains(car.type)) {
        carsMapType.put(car.type, 1);
      } else
        carsMapType.put(car.type, carsMapType.get(car.type)+1);
    }

// Create HashMap Car Color - nr of cars:
    Map<Car.Color, Integer> carsMapColor = new HashMap<>();
    for (Car car : cars) {
      if (!carsMapColor.keySet().contains(car.color)) {
        carsMapColor.put(car.color, 1);
      } else
        carsMapColor.put(car.color, carsMapColor.get(car.color)+1);
    }

// Create Hashmap Car color+type - nr. of cars:
    Map<String, Integer> carsColorType = new HashMap<>();
    for (Car car : cars) {
      if (!carsColorType.keySet().contains(car.color + " " + car.type)) {
        carsColorType.put(car.color + " " + car.type, 1);
      } else
        carsColorType.put(car.color + " " + car.type, carsColorType.get(car.color + " " + car.type) + 1);
    }

// Find color+type car with the highest occurrence:
    int max = 0;
    String mostFreqCar = "";
    for (String s : carsColorType.keySet()) {
      if (carsColorType.get(s) > max) {
        mostFreqCar = s;
        max = carsColorType.get(s);
      }
    }

    System.out.println(carsMapType);
    System.out.println(carsMapColor);
    System.out.printf("\nMost frequently occuring vehicle = %s. There is %d of them.\n", mostFreqCar, max);
  }
}
