package AnagramComparePackage;

public class AnagramCompare {

  private String one;
  private String two;

  public AnagramCompare(String one, String two) {
    this.one = one;
    this.two = two;
  }

  public boolean doCompare() {
    if ((one == null && two == null) || (one == "" && two =="")) {
      return true;
    }
    if (one == null || two == null || one =="" || two == "") {
      return false;
    }
    if (one.length() != two.length()) {
      return false;
    }
    for (int i = 0; i < one.length(); i++) {
      if (one.charAt(i) != two.charAt(one.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }
}
