package CABPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaBTest {

  CaB game;

  @BeforeEach
  void setup() {
    game = new CaB();
    game.setNumberToGuess("1234");
  }

  @Test
  @DisplayName("Should get result 4C0B")
  void shouldGetResult4C0B() {
    assertEquals("4C0B", game.guess("1234"));
  }

  @Test
  @DisplayName("Should get result 0C3B")
  void shouldGetResult0C3B() {
    assertEquals("0C3B", game.guess("5123"));
  }

  @Test
  @DisplayName("Should get result 0C0B")
  void shouldGetResult0C0B() {
    assertEquals("0C0B", game.guess("5678"));
  }

  @Test
  @DisplayName("Should get result 1C3B")
  void shouldGetResult1C3B() {
    assertEquals("1C3B", game.guess("1111"));
  }

@Test
@DisplayName("Should set state to finished")
void shouldSetStateToFinished() {
  game.guess("1234");
  assertEquals("finished", game.getState() );
}

@Test
@DisplayName("Should set state to playing")
void shouldSetStateToPlaying() {
  game.guess("1235");
  assertEquals("playing", game.getState() );
}


  @Test
  @DisplayName("Should get counter 3")
  void shouldGetCounter3() {
    game.setCounter(3);
    assertEquals(3, game.getCounter());
  }

  @Test
  @DisplayName("Should get correct number to guess (1234)")
  void shouldGetCorrentNumberToGuess1234() {
    assertEquals("1234", game.getNumberToGuess());
  }





  
  




}