import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReversedOrder {

  public static void main(String[] args) {
    // Create a method that decrypts reversed-order.txt
    String encryptedFile = "src/ReversedOrder-source.txt";
    String decryptedFile = "src/ReversedOrder-output.txt";

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

    for (int i = inputLines.size()-1; i > -1; i--) {
      outputLines.add(inputLines.get(i));
    }

    try {
      Files.write(pathOut, outputLines);
    } catch (IOException e) {
      System.err.println("Could not write file");
    }
    System.out.printf("File content of file \"%s\" decrypted to file \"%s\"\n", input, output);
  }
}
