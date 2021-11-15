package com.greenfoxacademy.groot.models;

import com.greenfoxacademy.groot.exceptions.DivisionByZeroException;
import com.greenfoxacademy.groot.exceptions.MissingDataException;

import static jdk.nashorn.internal.objects.NativeMath.round;

public class Yondu {

  private Double distance;
  private Double time;
  private Double speed;

  public Yondu(Double distance, Double time) {
    if (distance == null || time == null) {
      throw new MissingDataException();
    } else if (time == 0) {
      throw new DivisionByZeroException();
    } else {
      this.distance = distance;
      this.time = time;
      speed = (double)(Math.round(distance/time * 100))/100;
    }
  }

  public Double getDistance() {
    return distance;
  }

  public Double getTime() {
    return time;
  }

  public Double getSpeed() {
    return speed;
  }
}
