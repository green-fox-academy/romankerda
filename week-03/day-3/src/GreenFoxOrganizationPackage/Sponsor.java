package GreenFoxOrganizationPackage;

public class Sponsor extends Person {

  private String company;
  private int hiredStudents;


  public Sponsor() {
    super();
    company = "Google";
    hiredStudents = 0;
  }

  public Sponsor(String name, int age, Gender gender, String company) {
    super(name, age, gender);
    this.company = company;
    hiredStudents = 0;
  }

  @Override
  public void introduce() {
    System.out.printf("Hi, I'm %s, a %d year old %s who represents %s " +
            "and hired %d students so far.\n", name, age, gender, company, hiredStudents);
  }

  public void hire() {
    hiredStudents += 1;
  }

  @Override
  public void getGoal() {
    System.out.println("My goal is: Hire brilliant junior software developers");
  }
}
