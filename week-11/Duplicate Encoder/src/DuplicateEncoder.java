import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DuplicateEncoder {

  public static void main(String[] args) {
    System.out.println(encode("Prespecialized"));
  }
  static String encode(String word){

    word = word.toLowerCase();
    StringBuilder sb = new StringBuilder();
    sb.append(word);
    Map<Character,Integer> map = new HashMap<>();

    for (int i = 0; i <word.length(); i++) {
      if (map.containsKey(word.charAt(i))) {
        map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
      } else {
        map.put(word.charAt(i), 1);
      }
    }
    for (int i = 0; i < sb.length(); i++) {
      if (map.get(sb.charAt(i)) == 1) {
        sb.replace(i, i+1, "(");
      } else {
        sb.replace(i, i+1, ")");
      }
    }
    return sb.toString();
  }
}