package com.greenfoxacademy.error.controllers;

import com.greenfoxacademy.error.services.UserService;
import com.greenfoxacademy.error.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by aze on 25/10/17.
 */
@Controller
@RequestMapping(value = "/app")
public class AppController {

    @Autowired
    UserService service;

    public AppController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "")
    public String index(Model model) {
        model.addAttribute("users", service.getAll());
        return "main";
    }

    @PostMapping("")
    public String create(@RequestParam String firstName, @RequestParam String lastName) {
        service.save(new User(firstName, lastName));
        return "redirect:/app";
    }
}