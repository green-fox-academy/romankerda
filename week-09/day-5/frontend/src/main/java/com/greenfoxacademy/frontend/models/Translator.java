package com.greenfoxacademy.frontend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Translator {

private String text;
private String lang;
private String translated;
private String langTranslated;
private static String vowels = "aeiouáéí";



  public void translate() {
    StringBuilder output = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
      if (vowels.indexOf(text.charAt(i)) != -1) {
        output.append(text.charAt(i));
        output.append("v");
        output.append(text.charAt(i));
      } else {
        output.append(text.charAt(i));
      }
    }
    translated = output.toString();
    langTranslated = "tbd";
  }

  @Override
  public String toString() {
    return "{" +
            "text='" + text + '\'' +
            ", lang='" + lang + '\'' +
            '}';
  }
}
