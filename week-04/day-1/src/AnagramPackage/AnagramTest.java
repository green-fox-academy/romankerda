package AnagramPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {
  Anagram anagram;

  @Test
  void anagramEmptyString() {
    anagram = new Anagram("");
    assertEquals("", anagram.makeAnagram());
  }

  @Test
  void anagramOneCharString() {
    anagram = new Anagram("A");
    assertEquals("A", anagram.makeAnagram());
  }

  @Test
  void anagramMoreCharString() {
    anagram = new Anagram("This is a test");
    assertEquals("tset a si sihT", anagram.makeAnagram());
  }

  @Test
  void anagramNullString() {
    anagram = new Anagram(null);
    assertEquals(null, anagram.makeAnagram());
  }
}