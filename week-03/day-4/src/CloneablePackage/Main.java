package CloneablePackage;

public class Main {
  public static void main(String[] args) {

    Student John = new Student("John", 20, Person.Gender.MALE, "BME");

    Student johnTheClone = John.clone();
    System.out.println("Student johnTheClone = " + johnTheClone.toString());
  }
}
