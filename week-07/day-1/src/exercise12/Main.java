package exercise12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {

    /*
    Create Stream expressions to perform the following exercises:
    Print the name of the heaviest character (if the mass is unknown, ignore that character)
    Print the average height of the male characters
    Print the average height of the female characters
    💪 Get the age distribution of the characters by gender (where the gender can be "male", "female" and "other")
    The age groups are: "below 21", "between 21 and 40", "above 40" and "unknown"
    The result should be a Map<String, Map<String, Integer>>
     */


    String inputFile = "src/exercise12/swcharacters.csv";
    List<Character> characterList = new ArrayList<>();

    try {
      List<String> fileLines = Files.readAllLines(Paths.get(inputFile));
      for (String line : fileLines) {
        String[] charArr = line.split(";");
        Character character = new Character(charArr[0], charArr[1], charArr[2],
                charArr[3], charArr[4], charArr[5], charArr[6], charArr[7]);
        characterList.add(character);
      }
      characterList.remove(0);
    } catch (IOException e) {
      System.err.println("Can't read file");
    }

    Optional<Character> heaviestCharacter = characterList.stream()
             .filter(ch -> ch.getMass() != -1)
             .max((character1, character2) -> character1.getMass() > character2.getMass() ? 1 : -1);

    System.out.println("\nName of the heaviest character : " + heaviestCharacter.get().getName());


    IntSummaryStatistics males = characterList.stream()
            .filter(ch -> ch.getHeight() != -1 && ch.getGender().equals("male"))
            .mapToInt(Character::getHeight)
            .summaryStatistics();

    IntSummaryStatistics females = characterList.stream()
            .filter(ch -> ch.getHeight() != -1 && ch.getGender().equals("female"))
            .mapToInt(Character::getHeight)
            .summaryStatistics();

    System.out.println("\nAverage height of male characters : " + Math.round(males.getAverage()));
    System.out.println("\nAverage height of female characters : " + Math.round(females.getAverage()));


    Map<String, Map<String, Long>> ageDistributionSimpleByGender = characterList.stream()
            .collect(Collectors.groupingBy(Character::getGender,
                    Collectors.groupingBy(Character::getAgeGroup,Collectors.counting())));

    System.out.println("\nDistribution of age groups by gender :");
    System.out.println(ageDistributionSimpleByGender);
  }
}

