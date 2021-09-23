package com.greenfoxacademy.musicPackage;

public class Violin extends StringedInstrument {

  private final String sound = "Screech";

  public Violin() {
    super();
    numberOfStrings = 4;
  }

  public Violin(int numberOfStrings) {
    super(numberOfStrings);
  }

  @Override
  public void sound() {
    System.out.println("Violin, a " + numberOfStrings + "-stringed instrument that goes " + sound);
  }
}
