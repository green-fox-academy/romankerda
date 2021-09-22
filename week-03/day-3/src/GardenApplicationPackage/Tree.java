package GardenApplicationPackage;

public class Tree extends Plant {

  public Tree() {
    super();
  }

  public Tree(Plant.Color color) {
    super(color);
  }

  @Override
  public void giveMeStatus() {
    int status = needWater() ? 1 : 0;
    String s = "";
    switch (status) {
      case 1 -> s = "needs";
      case 0 -> s = "doesn't need";
    }
    System.out.printf("The %s Tree %s water.\n", color, s);
  }

  @Override
  public void water(int waterAmount) {
    this.waterAmount += 0.4 * waterAmount;
  }

  @Override
  public boolean needWater() {
    return (waterAmount < 10 ? true : false);
  }
}
