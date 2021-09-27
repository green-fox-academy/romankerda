package SharpiePackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SharpieTest {

  Sharpie sharpie;

  @BeforeEach
  void setup() {
    sharpie = new Sharpie("blue", 0.60f);
  }



  @Test
  void colorSetup() {
    assertEquals("blue", sharpie.color);
  }

  @Test
  void widthSetup() {
    assertEquals(0.60, sharpie.width, 0.001);
  }

  @Test
  void inkAmount() {
    assertEquals(100, sharpie.getInkAmount(), 0.001);
  }

  @Test
  void inkAmountSet() {
    sharpie.setInkAmount(150);
    assertEquals(150, sharpie.getInkAmount(), 0.001);
  }

  @Test
  void useShouldDecreaseInkAmount() {
    sharpie.use();
    assertEquals(90, sharpie.getInkAmount());
  }

}