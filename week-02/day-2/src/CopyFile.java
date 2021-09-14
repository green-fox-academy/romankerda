import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CopyFile {
  public static void main(String[] args) {
//   Write a function that copies the contents of a file into another file
//   It should take two filenames (string) as parameters:
//    - path and name of the source file
//    - path and name of the target file
//   It should return a boolean that shows if the copy was successful

    String fileCopyFrom = "src/file1.txt";
    String fileCopyTo = "src/file2.txt";
    boolean copy = fileCopy(fileCopyFrom, fileCopyTo);
    System.out.printf("File %s copied to file %s : %b\n", fileCopyFrom, fileCopyTo, copy);
  }

  public static boolean fileCopy(String fileFrom, String fileTo) {
    Path pathFrom = Paths.get(fileFrom);
    Path pathTo = Paths.get(fileTo);
    try {
      List<String> fileFromContent = Files.readAllLines(pathFrom);
      Files.write(pathTo, fileFromContent);
      return true;
    }
    catch (IOException e) {
      return false;
    }
  }
}
