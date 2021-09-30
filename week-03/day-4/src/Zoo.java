import com.greenfoxacademy.animals.*;

public class Zoo {

  public static void main(String[] args) {

    Reptile reptile = new Reptile("Crocodile");
    Mammal mammal = new Mammal("Koala");
    Bird bird = new Bird("Parrot");

    System.out.println("How do you breed?");
    breed(reptile);
    breed(mammal);
    breed(bird);
  }

  public static void breed(Animal animal) {
    System.out.println("A " + animal.getName() + " is breeding by " + animal.breed() + ".");
  }
}
