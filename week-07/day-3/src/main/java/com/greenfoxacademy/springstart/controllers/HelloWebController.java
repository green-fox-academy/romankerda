package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HelloWebController {

    private static AtomicLong counter = new AtomicLong(1);

    @RequestMapping(value = "/web/greeting")
    public String greeting(Model model, @RequestParam (defaultValue = "Anonymous User") String name) {
        model.addAttribute("name", "World");
        model.addAttribute("userName", name);
        model.addAttribute("counter", counter.getAndIncrement());
        return "greeting";
    }
}
