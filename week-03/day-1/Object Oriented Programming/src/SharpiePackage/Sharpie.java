package SharpiePackage;

public class Sharpie {

  String color;
  float width;
  float inkAmount;

  public Sharpie(String color, float width) {
    this.color = color;
    this.width = width;
    this.inkAmount = 100;
  }

  void use() {
    this.inkAmount = this.inkAmount - 10;
  }

  @Override
  public String toString() {
    return "Sharpie{" +
            "color='" + color + '\'' +
            ", width=" + width +
            ", inkAmount=" + inkAmount +
            '}';
  }


}
