package AnimalPackage;

import java.util.ArrayList;
import java.util.List;

public class Farm {

  private List<Animal> list;
  private final int capacity = 2;

  public Farm() {
    list = new ArrayList<>();
  }

  public void breed() {
    if (this.list.size() < capacity) {
      Animal newAnimal = new Animal();
      this.list.add(newAnimal);
    } else {
      System.out.println("Can't breed new Animal, farm is full");
    }
  }

  public void addAnimal(Animal animal) {
    if (this.list.size() < capacity) {
      this.list.add(animal);
    } else {
      System.out.println("Can't breed new Animal, farm is full");
    }
  }

  public void sell() {
    if (list.size() == 0) {
      System.out.println("No animals in the farm, nothing to sell");
      return;
    }
    int max = (int) Double.POSITIVE_INFINITY;
    Animal leastHungry = null;
    for (Animal animal : this.list) {
      if (animal.hunger < max) {
        max = animal.hunger;
        leastHungry = animal;
      }
    }
    list.remove(leastHungry);
  }

  @Override
  public String toString() {
    return "Farm{" +
            "list=" + list +
            '}';
  }
}
