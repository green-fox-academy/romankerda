package com.greenfoxacademy.reservations;

import java.util.Random;

public class Reservation implements Reservationy {


  private final String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
  private String code;
  private final String forCode = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private String day;

  public Reservation() {
    Random rn = new Random();
    this.day = days[rn.nextInt(days.length)];
    code = "";
    for (int i = 0; i < 8; i++) {

      char ch = forCode.charAt(rn.nextInt(forCode.length()));
      code += ch;
    }
  }

  @Override
  public String getDowBooking() {
    return day.substring(0, 3);
  }

  @Override
  public String getCodeBooking() {
    return code;
  }
}
