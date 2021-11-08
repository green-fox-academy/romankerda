package com.greenfoxacademy.frontend.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.frontend.models.*;
import com.greenfoxacademy.frontend.models.DTO.*;
import com.greenfoxacademy.frontend.models.Number;
import com.greenfoxacademy.frontend.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

  LogRepository logRepository;

  @Autowired
  public MainController(LogRepository logRepository) {
    this.logRepository = logRepository;
  }

  @GetMapping(value = "/")
  public String start() {
    return "index";
  }


  public void saveLog(HttpServletRequest request) {
    Log log = new Log();
    log.setEndpoint(request.getServletPath());
    log.setData(request.getQueryString());
    log.setDate(new Date());
    logRepository.save(log);
  }

  @GetMapping(value = "/doubling")
  @ResponseBody
  public ResponseEntity doubling(@RequestParam(required = false) Optional<Integer> input,
                                 HttpServletRequest request) {
    saveLog(request);
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
                              @RequestParam(required = false) Optional<String> title,
                              HttpServletRequest request) {
    saveLog(request);
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
  public ResponseEntity appenda(@PathVariable String appendable, HttpServletRequest request) {
    saveLog(request);
    Appenda text = new Appenda(appendable);
    return ResponseEntity.status(HttpStatus.OK).body(text);
  }

  @PostMapping(value = "/dountil/{operation}")
  @ResponseBody
  public ResponseEntity doUntil(@PathVariable String operation,
                                @RequestBody(required = false) String until,
                                HttpServletRequest request) {

    Log log = new Log();
    log.setEndpoint(request.getServletPath());
    log.setData(until);
    log.setDate(new Date());
    logRepository.save(log);

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
  public ResponseEntity arrays(@RequestBody(required = false) String input,
                               HttpServletRequest request) {
    Log log = new Log();
    log.setEndpoint(request.getServletPath());
    log.setData(input);
    log.setDate(new Date());
    logRepository.save(log);

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
    LogsDTO logsDTO = new LogsDTO();
    logsDTO.setEntry_count(logRepository.countLogs());

    List<Log> logs = logRepository.listLogs();
    List<LogDTO> logDTOList = new ArrayList<>();
    for (Log log : logs) {
      LogDTO logDTO = new LogDTO();
      logDTO.setId(log.getId());
      logDTO.setEndpoint(log.getEndpoint());
      logDTO.setData(log.getData());
      logDTOList.add(logDTO);
    }
    logsDTO.setEntries(logDTOList);
    return ResponseEntity.status(HttpStatus.OK).body(logsDTO);
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




