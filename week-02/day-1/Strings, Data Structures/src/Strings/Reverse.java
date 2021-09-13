package Strings;

public class Reverse {
  public static void main(String... args){
    String toBeReversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";

    // Create a method that can reverse a String which is passed as parameter
    // Pass the toBeReversed variable to this method to check if it works well
    // Solve this task using charAt() function first
    // Try other solutions when you are done

    System.out.println(reverse(toBeReversed));
    System.out.println(reverseAlt(toBeReversed));
  }

  public static String reverse(String input) {
    String output = "";
    for (int i = input.length()-1; i >-1 ; i--) {
      output += input.charAt(i);
    }
    return output;
  }

  public static StringBuilder reverseAlt(String input) {
    StringBuilder output = new StringBuilder(input);
    return output.reverse();
  }
}