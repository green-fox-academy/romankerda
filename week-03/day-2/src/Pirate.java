public class Pirate {

  public enum Status {
    ALIVE, DEAD, UNCONSCIOUS
  }
  private int intoxication;
  private Status status;
  boolean hasParrot;
  private String name;


  public Pirate(String name) {
    status = Status.ALIVE;
    intoxication = 0;
    this.name = name;
  }



  public void drinkSomeRum() {
    intoxication++;
  }

  public void howIsItGoingMate() {
    if (status == Status.DEAD) System.out.println("he's dead");
    else {
      if (intoxication < 4) {
        System.out.println("Pour me anudder");
      } else {
        System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
        passOut();
        sleep();
      }
    }
  }

  public void sleep() {
    if (status == Status.DEAD) System.out.println("he's dead");
    else intoxication = 0;
  }

  public void passOut() {
    if (status == Status.DEAD) System.out.println("he's dead");
    else status = Status.UNCONSCIOUS;
  }

  public void die() {
    if (status == Status.DEAD) System.out.println("he's dead");
    else status = Status.DEAD;
  }

  public void brawl(Pirate pirate) {
    if (this.status == Status.DEAD) System.out.println("he's dead");
    int result = (int) (Math.random() * 3);
    switch (result) {
      case 0:
        this.die();
        break;
      case 1:
        pirate.die();
        break;
      case 2:
        this.passOut();
        pirate.passOut();
        break;
    }
  }

  public void addParrot() {
    if (status == Status.DEAD) System.out.println("he's dead");
    else hasParrot = true;
  }

  public int getIntoxication() {
    return intoxication;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public boolean isHasParrot() {
    return hasParrot;
  }

  public String getName() {
    return name;
  }
}
