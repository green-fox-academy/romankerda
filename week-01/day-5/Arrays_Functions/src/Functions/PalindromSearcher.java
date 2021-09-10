package Functions;

import java.util.Arrays;

public class PalindromSearcher {
  public static void main(String[] args) {

    //Create a function named searchPalindrome() following your current language's style guide.
    // It should take a string, search for palindromes that is at least 3 characters long
    // and return a list with the found palindromes.

    System.out.println(Arrays.toString(searchPalindrome("dog goat dad duck doodle never")));

  }

  public static String[] searchPalindrome(String input) {
    //create new string[] for all combination of substrings >= 3, length depends on input.length
    int size = 0;
    int count = 1;
    for (int i = input.length(); i > 2 ; i--) {
      size += count;
      count++;
    }
    String[] posStrings = new String[size];

    //fill new string[] with all possible words (>=3), substring(ind, ind);
    int wordLength;
    int pos = 0;

    for (int i = 0; i < input.length(); i++) {
      wordLength = input.length() - i;
      if (wordLength >= 3) {
        for (int j = 0; j < input.length() - wordLength + 1; j++) {
          posStrings[pos] = input.substring(j, j + wordLength);
          pos++;
        }
      }
    }

    //iterate new string[] - ifPalindrome, keep it, if not, put "no"; countPalindroms
    count = 0;
    for (int i = 0; i < posStrings.length; i++) {
      if (isPalindrome(posStrings[i])) {
        count++;
      } else {
        posStrings[i] = "no";
      }
    }

    //new clean string, length - countPalidnroms, iterate new string copy palindroms here
    String[] output = new String[count];
    pos = 0;
    for (int i = 0; i < posStrings.length; i++){
      if (!posStrings[i].equals("no")){
        output[pos] = posStrings[i];
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
