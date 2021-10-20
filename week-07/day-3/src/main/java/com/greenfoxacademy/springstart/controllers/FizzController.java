package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class FizzController {

    private static AtomicLong counter = new AtomicLong(1);
    private String print;
    private String size;

    @RequestMapping(value = "/web/fizz")
    public String greeting(Model model) {
        boolean fizz = false;
        boolean buzz = false;
        boolean woof = false;
        int countFizz = 0;
        if (counter.get() % 3 == 0) {
            fizz = true;
        }
        if (counter.get() % 5 == 0) {
            buzz = true;
        }
        if (counter.get() % 7 == 0) {
            woof = true;
        }

        if (!fizz && !buzz && !woof) {
            print = counter.getAndIncrement() + " ";
            size = "20";
        } else {
            StringBuilder sb = new StringBuilder();
            counter.incrementAndGet();
            if (fizz) {
                sb.append("Fizz ");
                countFizz ++;
            }
            if (buzz) {
                sb.append("Buzz ");
                countFizz ++;
            }
            if (woof) {
                sb.append("Woof ");
                countFizz ++;
            }
            print = sb.toString();
            size = String.valueOf(countFizz * 24);
        }
        model.addAttribute("name", print);
        model.addAttribute("size", size);
       return "fizz";
    }
}
