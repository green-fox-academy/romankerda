package ComparablePackage;

/**
 * Created by aze on 2017.03.29..
 */
public class Thing implements Comparable<Thing> {
  private String name;
  private boolean completed;

  public Thing(String name) {
    this.name = name;
  }

  public void complete() {
    this.completed = true;
  }

  @Override
  public String toString() {
    return (completed ? "[x] " : "[ ] ") + name;
  }

  @Override
  public int compareTo(Thing other) {
    if (this.completed != other.completed) {
      return this.completed ? 1 : -1;
    } else {
      return this.name.compareTo(other.name);
    }
  }
}
