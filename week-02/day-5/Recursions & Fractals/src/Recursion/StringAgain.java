package Recursion;

public class StringAgain {
  public static void main(String[] args) {
    // Given a string,
// compute recursively a new string where
// all the 'x' chars have been removed.

    System.out.println(removeX("xOUERTAGHADGFDJxxxTOUEFXx", 0));
  }

  public static String removeX(String s, int ind) {
    if (ind == s.length()) {
      return "";
    }
    if (s.charAt(ind) == 'x') {
      return "" + removeX(s, ind + 1);
    } else return s.charAt(ind) + removeX(s, ind + 1);


  }

}