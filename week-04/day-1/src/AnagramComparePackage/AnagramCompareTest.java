package AnagramComparePackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramCompareTest {

  AnagramCompare anagram;

  @Test
  void compareIfOneIsNullFalse() {
    anagram = new AnagramCompare(null, "a");
    assertFalse(anagram.doCompare());
  }

  @Test
  void compareIfBothAreNull() {
    anagram = new AnagramCompare(null, null);
    assertTrue(anagram.doCompare());
  }

  @Test
  void compareIfOneIsEmpty() {
    anagram = new AnagramCompare("apple", "");
    assertFalse(anagram.doCompare());
  }

  @Test
  void compareIfBothAreEmpty() {
    anagram = new AnagramCompare("", "");
    assertTrue(anagram.doCompare());
  }

  @Test
  void compareDiffWords() {
    anagram = new AnagramCompare("apple", "fruit");
    assertFalse(anagram.doCompare());
  }

  @Test
  void compareAnagram() {
    anagram = new AnagramCompare("apple", "elppa");
    assertTrue(anagram.doCompare());
  }




}