import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe {

  public static void main(String[] args) {
    // Write a function that takes a filename as a parameter
    // The file contains an ended Tic-Tac-Toe match
    // We have provided you some example files (draw.txt, win-x.txt, win-o.txt)
    // Return "X", "O" or "Draw" based on the input file's content

    System.out.println(ticTacResult("src/win-o.txt"));
    // Should print "O"

    System.out.println(ticTacResult("src/win-x.txt"));
    // Should print "X"

    System.out.println(ticTacResult("src/draw.txt"));
    // Should print "Draw"
  }

  public static String ticTacResult(String inputFile) {
    Path path = Paths.get(inputFile);
    List<String> lines = new ArrayList<>();
    int countX = 0;
    int CountO = 0;

    try {
      lines = Files.readAllLines(path);
    } catch (IOException e) {
      System.err.println("Could not read file");
    }

    char[][] matrix = new char[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        matrix[i][j] = lines.get(i).charAt(j);
      }
    }

    int count = 0;
    String word = "";
    List<String> combinations = new ArrayList<>();

    for (String s : lines) {
      combinations.add(s);
    }

    for (int i = 0; i < 3; i++) {
      for (String s : lines) {
        word += s.charAt(i);
      }
      combinations.add(word);
      word = "";
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == j) {
          word += matrix[j][i];
        }
      }
    }
    combinations.add(word);

    word = "" + matrix[2][0] + matrix[0][0] + matrix[0][2];
    combinations.add(word);

    if (combinations.contains("XXX")){
      return "X";
    } else if (combinations.contains("OOO")) {
      return "O";
    } else return "draw";
  }
}