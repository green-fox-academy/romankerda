package CountLettersPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {

  Dictionary dictionary;

  @BeforeEach
  void setup() {
    dictionary = new Dictionary();
  }

  @Test
  void makeDictionaryFromWord() {
    Map<String, Integer> output = new HashMap<>();
    output.put("a",1);
    output.put("p", 2);
    output.put("l", 1);
    output.put("e", 1);
    assertEquals(output, dictionary.makeDictionary("apple"));
  }

  @Test
  void makeDictionaryFromEmptyString() {
    Map<String, Integer> output = new HashMap<>();
    assertEquals(output, dictionary.makeDictionary(""));
  }

  @Test
  void makeDictionaryFromNullString() {
    Map<String, Integer> output = new HashMap<>();
    assertEquals(output, dictionary.makeDictionary(null));
  }
}