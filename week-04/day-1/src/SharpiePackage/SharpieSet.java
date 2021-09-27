package SharpiePackage;

import java.util.List;

public class SharpieSet {

  List<Sharpie> list;

  public SharpieSet() {
    this(null);
  }

  public SharpieSet(List<Sharpie> list) {
    this.list = list;
  }

  public void add(Sharpie sharpie) {
    this.list.add(sharpie);
  }

  public int countUsable() {
    int count = 0;
    for (Sharpie sharpie: this.list) {
      if (sharpie.getInkAmount() > 0) {
        count++;
      }
    }
    return count;
  }

  // remove empty sharpies:
  public void removeTrash() {
    for (Sharpie sharpie: this.list) {
      if (sharpie.getInkAmount() == 0) {
        list.remove(sharpie);
      }
    }

  }



}
