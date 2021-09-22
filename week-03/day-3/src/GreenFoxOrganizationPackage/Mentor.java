package GreenFoxOrganizationPackage;

public class Mentor extends Person {

  public enum Level {
    JUNIOR, INTERMEDIATE, SENIOR;

    @Override
    public String toString() {
      return super.toString().toLowerCase();
    }
  }

  Level level;

  public Mentor() {
    this.level = Level.INTERMEDIATE;
  }

  public Mentor(String name, int age, Gender gender, Level level) {
    super(name, age, gender);
    this.level = level;
  }

  @Override
  public void getGoal() {
    System.out.println("My goal is: Educate brilliant junior software developers.");
  }

  @Override
  public void introduce() {
    System.out.printf("Hi I'm %s, a %d year old %s %s mentor.\n", name, age, gender, level);
  }
}
