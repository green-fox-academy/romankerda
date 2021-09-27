package CountLettersPackage;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

  HashMap<String, Integer> dictionary;

  public Dictionary() {
    dictionary = new HashMap<>();
  }

  public HashMap<String, Integer> makeDictionary(String input) {
    if (input == null) {
      dictionary.clear();
      return dictionary;
    }
    dictionary.clear();
    for (int i = 0; i < input.length(); i++) {
      if (dictionary.containsKey(Character.toString(input.charAt(i)))) {
        dictionary.put(Character.toString(input.charAt(i)), dictionary.get(Character.toString(input.charAt(i))) + 1);
      } else
        dictionary.put(Character.toString(input.charAt(i)), 1);
    }
    return dictionary;
  }
}
