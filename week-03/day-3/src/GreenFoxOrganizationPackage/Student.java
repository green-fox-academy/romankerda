package GreenFoxOrganizationPackage;

public class Student extends Person {

  private String previousOrganization;
  private int skippDays;

  public Student() {
    super();
    this.previousOrganization = "The School of Life";
    this.skippDays = 0;
  }

  public Student(String name, int age, Gender gender, String previousOrganization) {
    super(name, age, gender);
    this.previousOrganization = previousOrganization;
    this.skippDays = 0;
  }

  @Override
  public void getGoal() {
    System.out.println("My goal is: Be a junior software developer.");
  }

  @Override
  public void introduce() {
    System.out.printf("Hi, I'm %s, a %d year old %s from %s who skipped %d days" +
            "from the course already.\n", name, age, gender, previousOrganization, skippDays);
  }

  public void skipDays(int numberOfDays) {
    this.skippDays += numberOfDays;
  }
}
