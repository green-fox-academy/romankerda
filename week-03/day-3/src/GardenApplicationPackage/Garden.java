package GardenApplicationPackage;

import java.util.ArrayList;
import java.util.List;

public class Garden {

  List<Plant> plants;

  public Garden() {
    plants = new ArrayList<>();
  }

  public void add(Plant plant) {
    plants.add(plant);
  }

  public void water(int waterAmount) {
    int counter = 0;
    for (Plant plant : plants) {
      if (plant.needWater()) counter++;
    }
    for (Plant plant : plants) {
      if (plant.needWater()) plant.water(waterAmount / counter);
    }
    System.out.printf("Watering with %d\n", waterAmount);
    showStatus();
  }


  public void showStatus() {
    for (Plant plant : plants) {
      plant.giveMeStatus();
    }
    System.out.println();
  }
}
