package AircraftCarrierPackage;

public class Main {
  public static void main(String[] args) throws NoAmmoException {

    Carrier carrier1 = new Carrier(5000, 5000);
    Carrier carrier2 = new Carrier(3000, 3500);

    Aircraft one = new F16();
    Aircraft two = new F16();
    Aircraft three = new F16();
    Aircraft four = new F16();
    Aircraft five = new F16();
    Aircraft six = new F16();
    Aircraft seven = new F35();
    Aircraft eight = new F35();
    Aircraft nine = new F35();
    Aircraft ten = new F35();
    Aircraft eleven = new F35();
    Aircraft twelve = new F35();
    Aircraft thirteen = new F35();

    carrier1.add(one);
    carrier1.add(three);
    carrier1.add(five);
    carrier1.add(seven);
    carrier1.add(nine);
    carrier1.add(eleven);
    carrier1.add(thirteen);

    carrier2.add(two);
    carrier2.add(four);
    carrier2.add(six);
    carrier2.add(eight);
    carrier2.add(ten);
    carrier2.add(twelve);


    System.out.println(carrier1.getStatus());
    System.out.println(carrier2.getStatus());

    carrier2.fill();
    System.out.println(carrier2.getStatus());

    carrier1.fill();
    System.out.println(carrier1.getStatus());
    System.out.println(carrier2.getStatus());

    System.out.println("1 fight 2");
    carrier1.fight(carrier2);
    System.out.println(carrier1.getStatus());
    System.out.println(carrier2.getStatus());

    System.out.println("1 fight 2 again");
    carrier1.fight(carrier2);
    System.out.println(carrier1.getStatus());
    System.out.println(carrier2.getStatus());


    System.out.println("1 reFill");
    carrier1.fill();System.out.println(carrier1.getStatus());
    System.out.println(carrier2.getStatus());

    System.out.println("1 fight 2 again");
    carrier1.fight(carrier2);
    System.out.println(carrier1.getStatus());
    System.out.println(carrier2.getStatus());













  }
}
