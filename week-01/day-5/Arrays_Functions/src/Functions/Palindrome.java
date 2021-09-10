package Functions;

import java.util.Arrays;

public class Palindrome {
  public static void main(String[] args) {

    //Create a function named createPalindrome() following your current language's style guide.
    // It should take a string, create a palindrome from it and then return it.

    System.out.println(createPalindrome("put"));

  }

  public static String createPalindrome(String input) {

    char[] inputArr = input.toCharArray();
    char[] outputArr = new char[2*inputArr.length];

    for (int i = 0; i < inputArr.length; i++) {
      outputArr[i] = inputArr[i];
    }
    for (int i = 0; i < inputArr.length; i++) {
      outputArr[inputArr.length+i] = inputArr[inputArr.length-1-i];
    }
    String result = "";
    for (int i = 0; i < outputArr.length; i++) {
      result = result + outputArr[i];
    }
    return result;
  }
}

