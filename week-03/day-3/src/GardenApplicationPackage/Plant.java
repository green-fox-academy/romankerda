package GardenApplicationPackage;

public class Plant {

  public enum Color {
    WHITE, BLUE, YELLOW, RED, GREEN, PINK, MAGENTA, PURPLE, ORANGE;

    @Override
    public String toString() {
      return super.toString().toLowerCase();
    }
  }
  protected Color color;
  protected double waterAmount;

  public Plant() {
    color = Color.WHITE;
    waterAmount = 0;
  }

  public Plant(Color color) {
    this.color = color;
    this.waterAmount = 0;
  }

  public void giveMeStatus() {
    int status = needWater() ? 1 : 0;
    String s = "";
    switch (status) {
      case 1 -> s = "needs";
      case 0 -> s = "doesn't need";
    }
    System.out.printf("The %s Flower %s water.\n", color, s);
  }

  public void water(int waterAmount) {
    this.waterAmount += 0.75 * waterAmount;
  }

  public boolean needWater() {
    return (waterAmount < 5 ? true : false);
  }
}
