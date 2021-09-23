package com.greenfoxacademy.music;

public class ElectricGuitar extends StringedInstrument {

  private final String sound = "Twang";

  public ElectricGuitar() {
    super();
    numberOfStrings = 6;
  }

  public ElectricGuitar(int numberOfStrings) {
    super(numberOfStrings);
  }

  @Override
  public void sound() {
    System.out.println("Electric Guitar, a " + numberOfStrings + "-stringed instrument that goes " + sound);
  }
}

