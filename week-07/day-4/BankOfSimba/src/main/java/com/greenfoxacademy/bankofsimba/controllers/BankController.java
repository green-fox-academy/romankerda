package com.greenfoxacademy.bankofsimba.controllers;

import com.greenfoxacademy.bankofsimba.models.AnimalType;
import com.greenfoxacademy.bankofsimba.models.BankAccount;
import com.greenfoxacademy.bankofsimba.services.BankAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class BankController {
  BankAccountService bankAccountService = new BankAccountService();

  @GetMapping(value = "/show")
  public String show(Model model) {
    model.addAttribute("account", new BankAccount("Simba", 2000, AnimalType.LION, true));
    return "index";

  }

  @GetMapping(value = "/accounts")
  public String showAll(Model model) {
    model.addAttribute("accountsList", bankAccountService.getAll());
    model.addAttribute("types", AnimalType.values());
    return "accounts";
  }

  @PostMapping(value = "/raise/{id}")
  public String raise(@PathVariable int id) {
    bankAccountService.raise(id);
  return "redirect:/accounts";
  }

  @PostMapping(value = "/add-new-account")
  public String addAccount(@ModelAttribute BankAccount bankAccount) {
    bankAccountService.addNew(bankAccount);
    return "redirect:/accounts";
  }
}
