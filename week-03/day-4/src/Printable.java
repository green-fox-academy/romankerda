import Printable.*;

import java.util.ArrayList;
import java.util.List;

public class Printable {
  public static void main(String[] args) {

    Domino dom1 = new Domino(1, 6);
    Domino dom2 = new Domino(1, 2);
    Domino dom3 = new Domino(5, 3);
    Domino dom4 = new Domino(4, 4);

    List<Domino> dominoes = new ArrayList<Domino>();
    dominoes.add(dom1);
    dominoes.add(dom2);
    dominoes.add(dom3);
    dominoes.add(dom4);

    for (Domino d : dominoes) {
      d.printAllFields();
    }
    System.out.println();

    Todo todo1 = new Todo("Buy milk", "high", true);
    Todo todo2 = new Todo("Sell car", "high", false);
    Todo todo3 = new Todo("Sleep", "low", false);
    Todo todo4 = new Todo("Work", "high", true);

    List<Todo> todos = new ArrayList();
    todos.add(todo1);
    todos.add(todo2);
    todos.add(todo3);
    todos.add(todo4);

    for (Todo t : todos) {
      t.printAllFields();
    }


  }
}
