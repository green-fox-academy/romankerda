package com.greenfoxacademy.frontend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

public class Reverser {

  private String text;
  private String sith_text;
  private static String[] wordsAdd = {"Arrgh. ", "Uhmm. ", "Err..err.err. "};

  public void reverse() {
    Random rand = new Random();
    StringBuilder textConverted = new StringBuilder();
    StringBuilder sentence = new StringBuilder();
    String[] sentences = text.split("[.]");
    for (int i = 0; i < sentences.length; i++) {
      sentences[i] = sentences[i].trim();
      String[] words = sentences[i].split(" ");
      for (int j = 0; j < words.length - 1; j += 2) {
        if (j == 0 && words.length > 1) {
          words[0] = words[0].toLowerCase();
          words[1] = words[1].substring(0, 1).toUpperCase() + words[1].substring(1);
        }
        String temp = words[j];
        words[j] = words[j + 1];
        words[j + 1] = temp;
      }
      for (String w : words) {
        sentence.append(w);
        sentence.append(" ");
      }
      sentence.deleteCharAt(sentence.length()-1);
      sentence.append(". ");
      textConverted.append(sentence);
      for (int j = 0; j < rand.nextInt(2) + 1; j++) {
        textConverted.append(wordsAdd[rand.nextInt(wordsAdd.length)]);
      }
      sentence.delete(0, sentence.length());
    }
    sith_text = textConverted.toString();
  }

  public String getSith_text() {
    return sith_text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
