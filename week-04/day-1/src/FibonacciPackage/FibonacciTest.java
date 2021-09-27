package FibonacciPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

  Fibonacci fib;

  @BeforeEach
  void setup() {
    fib = new Fibonacci();
  }

  @Test
  void test0() {
    assertEquals(0, fib.calc(0));
  }

  @Test
  void test1() {
    assertEquals(1, fib.calc(1));
  }

  @Test
  void test2() {
    assertEquals(1, fib.calc(2));
  }

  @Test
  void test3() {
    assertEquals(2, fib.calc(3));
  }

  @Test
  void test11() {
    assertEquals(89, fib.calc(11));
  }
}