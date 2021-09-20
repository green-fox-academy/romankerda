package AnimalPackage;

public class Animal {

  int hunger;
  int thirst;

  public Animal() {
    this(50, 50);
  }

  public Animal(int hunger, int thirst) {
    this.hunger = hunger;
    this.thirst = thirst;
  }

  void eat() {
    this.hunger--;
  }

  void drink() {
    this.thirst--;
  }

  void play() {
    this.hunger++;
    this.thirst++;
  }
}
