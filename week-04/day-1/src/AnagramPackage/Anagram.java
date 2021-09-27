package AnagramPackage;

public class Anagram {

  private String input;

  public Anagram(String input) {
    this.input = input;
  }

  public String makeAnagram() {
    if (input == null) {
      return null;
    }
    if (input.length()<2) {
      return input;
    }
    StringBuilder anagram = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      anagram.append(input.charAt(input.length() - 1 - i));
    }
    return anagram.toString();
  }
}
