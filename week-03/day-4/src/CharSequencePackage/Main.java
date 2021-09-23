package CharSequencePackage;

public class Main {
  public static void main(String[] args) {

    Gnirts gnirts = new Gnirts("example");
    System.out.println(gnirts.charAt(1));
    // should print out: l

    ShiftedCharSequence shifter = new ShiftedCharSequence("example", 2);
    System.out.println(shifter.charAt(0));
    // should print out: a
  }
}
