package CharSequencePackage;

public class Gnirts implements CharSequence {

  private String string;

  public Gnirts(String string) {
    this.string = string;
  }

  @Override
  public int length() {
    return string.length();
  }

  @Override
  public char charAt(int index) {
    char[] chars = string.toCharArray();
    return chars[string.length()-1 - index];
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    return null;
  }
}