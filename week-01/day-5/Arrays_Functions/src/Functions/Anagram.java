package Functions;

public class Anagram {
  public static void main(String[] args) {

    //Create a function named isAnagram() following your current language's style guide.
    // It should take two strings and return a boolean value
    // depending on whether it's an anagram or not.

    System.out.println(isAnagram("dog", "god"));
    System.out.println(isAnagram("dog", "goda"));
    System.out.println(isAnagram("do g", "g od"));
  }

  public static boolean isAnagram(String string1, String string2) {
    if (string1.length() != string2.length()) {
      return false;
    }
    char[] string1Arr = string1.toCharArray();
    char[] string2Arr = string2.toCharArray();
    char[] string2ArrRev = revert(string2Arr);

    for (int i = 0; i < string1Arr.length; i++) {
      if (string1Arr[i] != string2ArrRev[i]) {
        return false;
      }
    }
    return true;
  }

  public static char[] revert(char[] input) {
    char[] output = new char[input.length];
    for (int i = 0; i < input.length; i++) {
      output[i] = input[input.length-1-i];
    }
    return output;
  }

}
