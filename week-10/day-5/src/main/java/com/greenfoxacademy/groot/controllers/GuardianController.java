package com.greenfoxacademy.groot.controllers;

import com.greenfoxacademy.groot.dtos.MessageDto;
import com.greenfoxacademy.groot.dtos.MessageErrorDto;
import com.greenfoxacademy.groot.dtos.YonduSaveDto;
import com.greenfoxacademy.groot.exceptions.DivisionByZeroException;
import com.greenfoxacademy.groot.exceptions.MissingDataException;
import com.greenfoxacademy.groot.models.Message;
import com.greenfoxacademy.groot.models.Yondu;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GuardianController {


  @GetMapping("/groot")
  public ResponseEntity answer(@ModelAttribute Message message) {
    if (message.getMessage() != null) {
      MessageDto dto = new MessageDto(message);
      return new ResponseEntity(dto, HttpStatus.OK);
    } else {
      return new ResponseEntity(new MessageErrorDto(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/yondu")
  public ResponseEntity answerYondu(@ModelAttribute YonduSaveDto yonduSaveDto) {
    try {
      Yondu yondu = new Yondu(yonduSaveDto.distance, yonduSaveDto.time);
      return new ResponseEntity(yondu, HttpStatus.OK);
    }
    catch (DivisionByZeroException e) {
      return new ResponseEntity("Time can't be zero", HttpStatus.FORBIDDEN);
    }
    catch (MissingDataException e) {
      return new ResponseEntity("No parameters provided", HttpStatus.BAD_REQUEST);

    }
  }
}

