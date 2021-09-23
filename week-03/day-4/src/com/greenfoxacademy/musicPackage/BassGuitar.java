package com.greenfoxacademy.musicPackage;

public class BassGuitar extends StringedInstrument {

  private final String sound = "Duum-duum-duum";

  public BassGuitar() {
    super();
    numberOfStrings = 4;
  }

  public BassGuitar(int numberOfStrings) {
    super(numberOfStrings);
  }

  @Override
  public void sound() {
    System.out.println("Bass Guitar, a " + numberOfStrings + "-stringed instrument that goes " + sound);
  }
}
