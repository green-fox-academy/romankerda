package AnimalPackage;

public class App {
  public static void main(String[] args) {

    Animal animalOne = new Animal();
    Farm farmOne = new Farm();

    farmOne.addAnimal(animalOne);
    System.out.println(farmOne);

    farmOne.breed();
    System.out.println(farmOne);

    farmOne.breed();
    System.out.println(farmOne);


    System.out.println("Sell:");
    farmOne.sell();
    System.out.println(farmOne);

    System.out.println("Sell again:");
    farmOne.sell();
    System.out.println(farmOne);

    System.out.println("Sell again:");
    farmOne.sell();
    System.out.println(farmOne);



  }
}
