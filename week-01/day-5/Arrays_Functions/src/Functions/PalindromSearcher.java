package Functions;

import java.util.Arrays;

public class PalindromSearcher {
  public static void main(String[] args) {

    //Create a function named searchPalindrome() following your current language's style guide.
    // It should take a string, search for palindromes that is at least 3 characters long
    // and return a list with the found palindromes.

    System.out.println(Arrays.toString(searchPalindrome("dog goat dad duck doodle never")));
    System.out.println(Arrays.toString(searchPalindrome("racecar")));
    System.out.println(Arrays.toString(searchPalindrome("now try czech word kajak, to see if it works")));

  }

  public static String[] searchPalindrome(String input) {
    //create new string[] for all combination of substrings >= 3, length depends on input.length
    int size = 0;
    int count = 1;
    for (int i = input.length(); i > 2 ; i--) {
      size += count;
      count++;
    }
    String[] subStrings = new String[size];

    //fill new string[]  with all possible words (>=3), substring(ind, ind);
    int wordLength;
    int pos = 0;

    for (int i = 0; i < input.length(); i++) {
      wordLength = input.length() - i;
      if (wordLength >= 3) {
        for (int j = 0; j < input.length() - wordLength + 1; j++) {
          subStrings[pos] = input.substring(j, j + wordLength);
          pos++;
        }
      }
    }

    //iterate new string[] - ifPalindrome, keep it, if not, put "no"; count Palindromes
    count = 0;
    for (int i = 0; i < subStrings.length; i++) {
      if (isPalindrome(subStrings[i])) {
        count++;
      } else {
        subStrings[i] = "no";
      }
    }

    //new clean string, length - countPalidnroms, iterate new string copy palindroms here
    String[] output = new String[count];
    pos = 0;
    for (int i = 0; i < subStrings.length; i++){
      if (!subStrings[i].equals("no")){
        output[pos] = subStrings[i];
        pos++;
      }
    }
    return output;
  }

  public static boolean isPalindrome(String input) {
    for (int i = 0; i < input.length()/2; i++) {
      if (input.charAt(i) != input.charAt(input.length()-1-i)) {
        return false;
      }
    }
    return true;
  }
}
