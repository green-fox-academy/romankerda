package SharpiePackage;

public class App {
  public static void main(String[] args) {
    Sharpie one = new Sharpie("Blue", 0.75F);
    System.out.println(one);
    one.use();
    System.out.println(one);
  }
}
