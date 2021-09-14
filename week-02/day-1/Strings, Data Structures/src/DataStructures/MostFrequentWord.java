package DataStructures;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentWord {
  public static void main(String[] args) {
    //Write a function that receives a sentence (string) as a parameter and returns the most frequent word of that sentence. If there are more results: return any of them.
    //
    //Test the method with the sentence from John Updike’s 'Rabbit, Run':
    //
    //But then they were married (she felt awful about being pregnant before but Harry had been talking about marriage for a while and anyway laughed when she told him in early February about missing her period and said Great she was terribly frightened and he said Great and lifted her put his arms around under her bottom and lifted her like you would a child he could be so wonderful when you didn’t expect it in a way it seemed important that you didn’t expect it there was so much nice in him she couldn’t explain to anybody she had been so frightened about being pregnant and he made her be proud) they were married after her missing her second period in March and she was still little clumsy dark-complected Janice Springer and her husband was a conceited lunk who wasn’t good for anything in the world Daddy said and the feeling of being alone would melt a little with a little drink.
    //Expected result: said or little
    String input = "she felt awful about being pregnant before but Harry had been talking about marriage for a while and anyway laughed when she told him in early February about missing her period and said Great she was terribly frightened and he said Great and lifted her put his arms around under her bottom and lifted her like you would a child he could be so wonderful when you didn’t expect it in a way it seemed important that you didn’t expect it there was so much nice in him she couldn’t explain to anybody she had been so frightened about being pregnant and he made her be proud) they were married after her missing her second period in March and she was still little clumsy dark-complected Janice Springer and her husband was a conceited lunk who wasn’t good for anything in the world Daddy said and the feeling of being alone would melt a little with a little drink.";
    System.out.println(mostFrequent(input));
  }

  public static String mostFrequent(String input) {
    Map<String, Integer> frequency = new HashMap<>();
    String[] words = input.split(" ");
    for (String s : words) {
      if (!frequency.containsKey(s)) {
        frequency.put(s, 1);
      } else {
        frequency.put(s, frequency.get(s) + 1);
      }
    }
    int max = 0;
    String word = "";
    for (String s : frequency.keySet()) {
      if (frequency.get(s) > max) {
        max = frequency.get(s);
        word = s;
      }
    }
    return word;
  }
}
