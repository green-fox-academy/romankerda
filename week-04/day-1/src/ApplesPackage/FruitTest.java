package ApplesPackage;

import ApplesPackage.Fruit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitTest {


  @Test
  public void shouldGetApple() {
    Fruit apple = new Fruit("apple");
    assertEquals("apple", apple.getName());
  }

}