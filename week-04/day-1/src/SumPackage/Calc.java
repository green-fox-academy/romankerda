package SumPackage;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Calc {

  public List<Integer> list;

  public Calc() {
    this.list = new ArrayList<>();
  }

  public List<Integer> getList() {
    return list;
  }

  public int sum() {
    if (this.list == null) {
      return 0;
    }
    int sum = 0;
    for (int i = 0; i < list.size(); i++) {
      sum += list.get(i);
    }
    return sum;
  }

  public void add(int number) {
    this.list.add(number);
  }
}
