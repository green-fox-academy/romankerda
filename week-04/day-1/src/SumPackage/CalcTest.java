package SumPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {
  Calc calc;

  @BeforeEach
  public void setup() {
    calc = new Calc();
    calc.add(1);
    calc.add(3);
    calc.add(5);
  }

  @Test
  void sumEmptyList() {
    calc = new Calc();
    assertEquals(0, calc.sum());
  }

  @Test
  void sumListWithOneElement() {
    calc = new Calc();
    calc.add(5);
    assertEquals(5, calc.sum());
  }

  @Test
  public void sumShouldSumCorrectly() {
    assertEquals(9, calc.sum());
  }

  @Test
  void sumNullCalc() {
    calc = new Calc();
    calc.list = null;
    assertEquals(0, calc.sum());
  }
}







