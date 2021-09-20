package DominoesPackage;

import java.util.ArrayList;
import java.util.List;

public class Dominoes {
  public static void main(String[] args) {
    List<Domino> dominoes = initializeDominoes();
    // You have the list of Dominoes
    // Order them into one snake where the adjacent dominoes have the same numbers on their adjacent sides
    // eg: [2, 4], [4, 3], [3, 5] ...
    
    List<Domino> dominoSnake = sort(dominoes);
    System.out.println(dominoSnake);
  }

  public static List<Domino> sort(List<Domino> dominoes) {
    List<Domino> input = new ArrayList<>();
    input.addAll(dominoes);
    List<Domino> sorted = new ArrayList<>();
    List<Domino> snake = new ArrayList<>();
    for (int i = 0; i < dominoes.size(); i++) {
      sorted.clear();
      sorted.add(dominoes.get(i));
      input.addAll(dominoes);
      input.remove(dominoes.get(i));
      snake = makeSnake(input, sorted);
      if (snake.size() == dominoes.size()) return snake;
    }
    return snake;
  }

   static List<Domino> makeSnake(List<Domino> input, List<Domino> sorted) {
     boolean found = false;
     do {
       for (int i = 0; i < input.size(); i++) {
         if (sorted.get(sorted.size() - 1).getRightSide() == input.get(i).getLeftSide()) {
           found = true;
           sorted.add(input.get(i));
           input.remove(input.get(i));
         } else found = false;
       }
     } while (found == true && input.size()>0);
     return sorted;
   }


  static List<Domino> initializeDominoes() {
    List<Domino> dominoes = new ArrayList<>();
    dominoes.add(new Domino(5, 2));
    dominoes.add(new Domino(4, 6));
    dominoes.add(new Domino(1, 5));
    dominoes.add(new Domino(6, 7));
    dominoes.add(new Domino(2, 4));
    dominoes.add(new Domino(7, 1));
    return dominoes;
  }
  
  
}
