package CharSequencePackage;

public class ShiftedCharSequence implements CharSequence {

private String string;
private int shift;

  public ShiftedCharSequence(String string, int shift) {
    this.string = string;
    this.shift = shift;
  }

  @Override
  public int length() {
    return string.length();
  }

  @Override
  public char charAt(int index) {
    char[] chars = string.toCharArray();
    return chars[index + shift];
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    return null;
  }
}
