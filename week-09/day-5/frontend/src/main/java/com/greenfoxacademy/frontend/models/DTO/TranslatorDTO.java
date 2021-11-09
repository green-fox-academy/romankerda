package com.greenfoxacademy.frontend.models.DTO;

import com.greenfoxacademy.frontend.models.Translator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class TranslatorDTO {

  private String translated;
  private String language;

  public TranslatorDTO(Translator translator) {
    translated = translator.getTranslated();
    language = translator.getLangTranslated();
  }

}
