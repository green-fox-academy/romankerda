package GardenApplicationPackage;

public class Main {
  public static void main(String[] args) {

    Flower yellowFlower = new Flower(Plant.Color.YELLOW);
    Flower blueFlower = new Flower(Plant.Color.BLUE);
    Tree purpleTree = new Tree(Plant.Color.PURPLE);
    Tree orangeTree = new Tree(Plant.Color.ORANGE);

    Garden garden = new Garden();
    garden.add(yellowFlower);
    garden.add(blueFlower);
    garden.add(purpleTree);
    garden.add(orangeTree);

    garden.showStatus();
    garden.water(40);
    garden.water(70);
  }
}
