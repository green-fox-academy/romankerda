package CABPackage;

import org.junit.jupiter.api.BeforeEach;
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
  void guessResult4Cows() {
    assertEquals("4C0B", game.guess("1234"));
  }

  @Test
  void guessResult3Bulls() {
    assertEquals("0C3B", game.guess("5123"));
  }

  @Test
  void guessResult0Cows0Bulls() {
    assertEquals("0C0B", game.guess("5678"));
  }

  @Test
  void guessResultWrongInput() {
    assertEquals("1C3B", game.guess("1111"));
  }

  @Test
  void setStateToFinished() {
    game.guess("1234");
    assertEquals("finished", game.getState() );
  }

  @Test
  void setStateToPlaying() {
    game.guess("1235");
    assertEquals("playing", game.getState() );
  }

}