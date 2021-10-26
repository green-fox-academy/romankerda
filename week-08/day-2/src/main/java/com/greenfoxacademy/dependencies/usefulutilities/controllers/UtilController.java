package com.greenfoxacademy.dependencies.usefulutilities.controllers;

import com.greenfoxacademy.dependencies.usefulutilities.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;


@Controller
public class UtilController {

  private UtilityService utilityService;

  @Autowired
  public UtilController(UtilityService utilityService) {
    this.utilityService = utilityService;
  }

  @GetMapping(value ="/useful")
  public String start() {
    return "index";
  }

  @GetMapping(value = "/useful/colored")
  public String colorBackground(Model model) {
    model.addAttribute("color", utilityService.randomColor());
    return "colored";
  }

  @GetMapping(value = "/useful/email")
  public String checkMailFormat(@RequestParam("check") String email, Model model) {
    model.addAttribute("email", email);
    model.addAttribute("isEmail", utilityService.isEmail(email));
    return "checkMailFormat";
  }

  @GetMapping(value = "/useful/caesar")
  public String encodeDecode(@RequestParam("text") String text, @RequestParam("number") int number, @RequestParam("type") String type, Model model) {
    if (type.toLowerCase().equals("encode")) {
      model.addAttribute("text", utilityService.caesar(text, number));
    } else {
      model.addAttribute("text", utilityService.caesar(text, number * -1));
    }
    return "caesar";
  }


}
