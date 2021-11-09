package com.greenfoxacademy.frontend.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.frontend.models.*;
import com.greenfoxacademy.frontend.models.DTO.*;
import com.greenfoxacademy.frontend.models.Number;
import com.greenfoxacademy.frontend.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class MainController {

  LogService logService;

  @Autowired
  public MainController(LogService logService) {
    this.logService = logService;
  }

  @GetMapping(value = "/")
  public String start() {
    return "index";
  }


  @GetMapping(value = "/doubling")
  @ResponseBody
  public ResponseEntity doubling(@RequestParam(required = false) Optional<Integer> input, HttpServletRequest request) {
    logService.saveLog(request);
    if (input.isPresent()) {
      return ResponseEntity.status(HttpStatus.OK).body(new Doubling(input.get(), input.get() * 2));
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(new DoublingErrorDTO());
    }
  }

  @GetMapping(value = "/greeter")
  @ResponseBody
  public ResponseEntity greet(@RequestParam(required = false) Optional<String> name,
                              @RequestParam(required = false) Optional<String> title,
                              HttpServletRequest request) {
    logService.saveLog(request);
    if (name.isPresent() && title.isPresent()) {
      return ResponseEntity.status(HttpStatus.OK).body(new GreeterDTO(new Greeter(name.get(), title.get())));
    }
    if (!name.isPresent() && !title.isPresent()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GreeterErrorDTO("Please provide a name and a title!"));
    }
    if (!name.isPresent()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GreeterErrorDTO("Please provide a name!"));
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GreeterErrorDTO("Please provide a title!"));
  }


  @GetMapping(value = "/appenda/{appendable}")
  @ResponseBody
  public ResponseEntity appenda(@PathVariable String appendable, HttpServletRequest request) {
    logService.saveLog(request);
    return ResponseEntity.status(HttpStatus.OK).body(new Appenda(appendable));
  }

  @PostMapping(value = "/arrays")
  @ResponseBody
  public ResponseEntity arrays(@RequestBody(required = false) String input,
                               HttpServletRequest request) {

    logService.saveLog(request);

    ObjectMapper mapper = new ObjectMapper();
    try {
      ArrayHandler arrayHandler = mapper.readValue(input, ArrayHandler.class);
      arrayHandler.calculate();
      if (arrayHandler.getWhat().equals("double")) {
        ArrayHandlerDoubleDTO doubleDTO = new ArrayHandlerDoubleDTO();
        doubleDTO.setResult(arrayHandler.getResultArr());
        return ResponseEntity.status(HttpStatus.OK).body(doubleDTO);
      } else {
        ArrayHandlerSumDTO sumDTO = new ArrayHandlerSumDTO();
        sumDTO.setResult(arrayHandler.getResult());
        return ResponseEntity.status(HttpStatus.OK).body(sumDTO);
      }
    } catch (JsonProcessingException e) {
      ArrayHandlerErrorDTO error = new ArrayHandlerErrorDTO();
      return ResponseEntity.status(HttpStatus.OK).body(error);
    }
  }

  @GetMapping(value = "/log")
  @ResponseBody
  public ResponseEntity logInfo() {
    return ResponseEntity.status(HttpStatus.OK).body(new LogsDTO(logService.getLogsDTO(), logService.countLogs()));
  }


  @PostMapping("/sith")
  @ResponseBody
  public ResponseEntity reverse(@RequestBody(required = false) Optional<String> input) {
    if (input.isPresent() || !input.get().isEmpty()) {
      ObjectMapper mapper = new ObjectMapper();
      try {
        Reverser reverser = mapper.readValue(input.get(), Reverser.class);
        if (reverser.getText() == null) {
          ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO("Feed me some text you have to, padawan young you are. Hmmm.");
          return ResponseEntity.status(HttpStatus.OK).body(errorMessageDTO);
        }
        reverser.reverse();
        return ResponseEntity.status(HttpStatus.OK).body(reverser);
      } catch (JsonProcessingException e) {
        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO("Feed me some text you have to, padawan young you are. Hmmm.");
        return ResponseEntity.status(HttpStatus.OK).body(errorMessageDTO);
      }
    } else {
      ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO("Feed me some text you have to, padawan young you are. Hmmm.");
      return ResponseEntity.status(HttpStatus.OK).body(errorMessageDTO);
    }
  }
}




