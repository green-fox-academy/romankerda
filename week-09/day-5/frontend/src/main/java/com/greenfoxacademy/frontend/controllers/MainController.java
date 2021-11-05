package com.greenfoxacademy.frontend.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.frontend.models.*;
import com.greenfoxacademy.frontend.models.DTO.*;
import com.greenfoxacademy.frontend.models.Number;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MainController {

  @GetMapping(value = "/")
  public String start() {
    return "index";
  }


  @GetMapping(value = "/doubling")
  @ResponseBody
  public ResponseEntity doubling(@RequestParam(required = false) Optional<Integer> input) {
    if (input.isPresent()) {
      Doubling doubling = new Doubling();
      doubling.setReceived(input.get());
      doubling.setResult(input.get() * 2);
      return ResponseEntity.status(HttpStatus.OK).body(doubling);
    } else {
      DoublingErrorDTO error = new DoublingErrorDTO();
      return ResponseEntity.status(HttpStatus.OK).body(error);
    }
  }

  @GetMapping(value = "/greeter")
  @ResponseBody
  public ResponseEntity greet(@RequestParam(required = false) Optional<String> name,
                              @RequestParam(required = false) Optional<String> title) {
    if (name.isPresent() && title.isPresent()) {
      Greeter greeter = new Greeter(name.get(), title.get());
      GreeterDTO greeterDTO = new GreeterDTO();
      greeterDTO.setWelcome_message(greeter.getWelcome_message());
      return ResponseEntity.status(HttpStatus.OK).body(greeterDTO);

    } else if (!name.isPresent() && !title.isPresent()) {
      GreeterErrorDTO greeterErrorDTO = new GreeterErrorDTO();
      greeterErrorDTO.setError("Please provide a name and a title!");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(greeterErrorDTO);

    } else if (!name.isPresent()) {
      GreeterErrorDTO greeterErrorDTO = new GreeterErrorDTO();
      greeterErrorDTO.setError("Please provide a name!");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(greeterErrorDTO);

    } else {
      GreeterErrorDTO greeterErrorDTO = new GreeterErrorDTO();
      greeterErrorDTO.setError("Please provide a title!");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(greeterErrorDTO);
    }
  }

  @GetMapping(value = "/appenda/{appendable}")
  @ResponseBody
  public ResponseEntity appenda(@PathVariable String appendable) {
    Appenda text = new Appenda(appendable);
    return ResponseEntity.status(HttpStatus.OK).body(text);
  }

  @PostMapping(value = "/dountil/{operation}")
  @ResponseBody
  public ResponseEntity dountil(@PathVariable String operation, @RequestBody (required = false) String until) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      Number number = mapper.readValue(until, Number.class);
      DoUntil doUntil = new DoUntil(operation, number.getUntil());
      return ResponseEntity.status(HttpStatus.OK).body(doUntil);
    } catch (JsonProcessingException e) {
      DoUntilErrorDTO error = new DoUntilErrorDTO();
      return ResponseEntity.status(HttpStatus.OK).body(error);
    }
  }


  @PostMapping(value = "/arrays")
  @ResponseBody
  public ResponseEntity arrays(@RequestBody (required = false) String input) {
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
}




