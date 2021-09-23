package com.greenfoxacademy.music;

public class StringedInstrument extends Instrument {

  protected int numberOfStrings;

  public StringedInstrument() {}

  public StringedInstrument(int numberOfStrings) {
    this.numberOfStrings = numberOfStrings;
  }

  @Override
  public void play() {
    sound();
  }

  public void sound() {}
}
