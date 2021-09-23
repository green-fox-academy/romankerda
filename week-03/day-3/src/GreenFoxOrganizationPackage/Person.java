package GreenFoxOrganizationPackage;

public class Person {

  public enum Gender {

    MALE, FEMALE;

    @Override
    public String toString() {
      return super.toString().toLowerCase();
    }
  }

  protected String name;
  protected int age;
  protected Gender gender;

  public Person() {
    this("Jane Doe", 30, Gender.FEMALE);
  }

  public Person(String name, int age, Gender gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  public void getGoal() {
    System.out.println("My goal is: Live for the moment!");
  }

  public void introduce() {
    System.out.printf("Hi, I'm %s, a %d year old %s.\n", name, age, gender);
  }
}
