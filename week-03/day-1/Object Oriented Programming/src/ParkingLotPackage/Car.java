package ParkingLotPackage;

public class Car {

  public enum Type {VW, SKODA, AUDI, PORSCHE, LAMBORGINI, SEAT, FERRARI, TOYOTA, PEUGEOT}
  public enum Color {WHITE, RED, PURPLE, BLUE, YELLOW, PINK, BLACK, GRAY}

  Type type;
  Color color;


  public Car(Type type, Color color) {
    this.type = type;
    this.color = color;
  }

  @Override
  public String toString() {
    return "Car{" +
            "type=" + type +
            ", color=" + color +
            '}';
  }
}
