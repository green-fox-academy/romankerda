import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Doubled {

  public static void main(String[] args) {
    // Create a method that decrypts the duplicated-chars.txt.
    // Decryption is the process reversing an encryption, i.e. the process
    // which converts encrypted data into its original form.

    String encryptedFile = "src/Doubled-source.txt";
    String decryptedFile = "src/Doubled-output.txt";

    decrypt (encryptedFile, decryptedFile);
  }

  public static void decrypt(String input, String output) {
    Path pathInp = Paths.get(input);
    Path pathOut = Paths.get(output);
    List<String> inputLines = new ArrayList<>();
    List<String> outputLines = new ArrayList<>();

    try {
      inputLines = Files.readAllLines(pathInp);
    } catch (IOException e) {
      System.err.println("Could not read file");
    }

    for (String s : inputLines) {
      String decrLine = "";
      for (int i = 0; i <s.length() ; i+= 2) {
        decrLine += s.charAt(i);
      }
      outputLines.add(decrLine);
    }

    try {
      Files.write(pathOut, outputLines);
    } catch (IOException e) {
      System.err.println("Could not write file");
    }
    System.out.printf("File content of file \"%s\" decrypted to file \"%s\"\n", input, output);
  }
}