package com.greenfoxacademy.frontend.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.frontend.models.DTO.DoUntilDTO;
import com.greenfoxacademy.frontend.models.DTO.DoUntilErrorDTO;
import com.greenfoxacademy.frontend.models.DTO.ErrorMessageDTO;
import com.greenfoxacademy.frontend.models.DTO.TranslatorDTO;
import com.greenfoxacademy.frontend.models.DoUntil;
import com.greenfoxacademy.frontend.models.Translator;
import com.greenfoxacademy.frontend.services.DoUntilService;
import com.greenfoxacademy.frontend.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class RestMainController {

  LogService logService;
  DoUntilService doUntilService;

  @Autowired
  public RestMainController(LogService logService, DoUntilService doUntilService) {
    this.logService = logService;
    this.doUntilService = doUntilService;
  }

  @PostMapping("/translate")
  public ResponseEntity translate(@RequestBody(required = false) Optional<Translator> translator, HttpServletRequest request) {
    logService.saveLog2(request, translator.toString());
    if (translator.isPresent() && translator.get().getLang() != null && translator.get().getText() != null) {
      translator.get().translate();
      return ResponseEntity.status(HttpStatus.OK).body(new TranslatorDTO(translator.get()));
    }
    return ResponseEntity.status(HttpStatus.OK).body(new ErrorMessageDTO("I can't translate that!"));
  }

  @PostMapping(value = "/dountil/{operation}")
  @ResponseBody
  public ResponseEntity doUntil(@PathVariable String operation,
                                @RequestBody(required = false) Optional<DoUntil> until,
                                HttpServletRequest request) {
    logService.saveLog(request);
    if (until.isPresent() && (operation.equals("sum") || operation.equals("factor")) && until.get().getUntil() != null) {
      switch (operation) {
        case "sum":
          DoUntil doUntil = new DoUntil(until.get().getUntil(), doUntilService.sum(until.get().getUntil()));
          return ResponseEntity.status(HttpStatus.OK).body(new DoUntilDTO(doUntil.getResult()));
        case "factor":
          doUntil = new DoUntil(until.get().getUntil(), doUntilService.factorial(until.get().getUntil()));
          return ResponseEntity.status(HttpStatus.OK).body(new DoUntilDTO(doUntil.getResult()));
      }
    }
    return ResponseEntity.status(HttpStatus.OK).body(new ErrorMessageDTO("Please provide a number!"));
  }
}




