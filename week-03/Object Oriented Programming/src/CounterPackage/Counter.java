package CounterPackage;

public class Counter {

  int counter;
  int counterOrig;

  public Counter() {
  }

  public Counter(int counter) {
    this.counter = counter;
    this.counterOrig = counter;
  }

  void add(int addNr) {
    this.counter += addNr;
  }

  void add() {
    this.counter++;
  }

  int get() {
    return this.counter;
  }

  void reset() {
    this.counter = counterOrig;
  }

}
