package Recursion;

public class Strings {
  public static void main(String[] args) {
// Given a string, compute recursively (no loops) a new string where
// all the lowercase 'x' chars have been changed to 'y' chars.

    System.out.println(changeXY("TEAEFDFAFADFADFyyyERERQy", 0));
  }

  public static String changeXY(String s, int ind) {
  if (ind == s.length()) {
    return "";
  }
  if (s.charAt(ind) == 'y') {
    return "x" + changeXY(s, ind + 1);
    } else return s.charAt(ind) + changeXY(s, ind + 1);


  }

}
