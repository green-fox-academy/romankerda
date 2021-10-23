package com.greenfoxacademy.basic_webshop.controllers;

import com.greenfoxacademy.basic_webshop.services.ShopItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShopController {
  ShopItemService shopItemService = new ShopItemService();

  @GetMapping(value ="/webshop")
  public String webshop(Model model) {
    model.addAttribute("list", shopItemService.getAll());
    model.addAttribute("format", "table");
    model.addAttribute("currency", shopItemService.getCurrency());
    return "index";
  }

  @GetMapping(value ="/only-available")
  public String onlyAvailable(Model model) {
    model.addAttribute("list", shopItemService.getOnlyAvailable());
    model.addAttribute("format", "table");
    model.addAttribute("currency", shopItemService.getCurrency());
    return "index";
  }

  @GetMapping(value ="/cheapest-first")
  public String cheapestFirst(Model model) {
    model.addAttribute("list", shopItemService.getCheapestFirst());
    model.addAttribute("format", "table");
    model.addAttribute("currency", shopItemService.getCurrency());
    return "index";
  }

  @GetMapping(value ="/contains-nike")
  public String containsNike(Model model) {
    model.addAttribute("list", shopItemService.getContainsNike());
    model.addAttribute("format", "table");
    model.addAttribute("currency", shopItemService.getCurrency());
    return "index";
  }

  @GetMapping(value ="/average-stock")
  public String averageStock(Model model) {
    model.addAttribute("avgStock", shopItemService.getAverageStock());
    model.addAttribute("format", "avgStock");
    model.addAttribute("currency", shopItemService.getCurrency());
    return "index";
  }

  @GetMapping(value ="/most-expensive")
  public String mostExpensive(Model model) {
    model.addAttribute("list", shopItemService.getMostExpensive());
    model.addAttribute("format", "mostExp");
    model.addAttribute("currency", shopItemService.getCurrency());
    return "index";
  }



  @PostMapping(value ="/search")
  public String search(Model model, @RequestParam("string") String text) {
    model.addAttribute("list", shopItemService.getSearch(text));
    model.addAttribute("format", "table");
    model.addAttribute("currency", shopItemService.getCurrency());
    return "index";
  }

  @GetMapping(value ="/more-filters")
  public String moreFilters(Model model) {
    model.addAttribute("list", shopItemService.getAll());
    model.addAttribute("format", "table");
    model.addAttribute("currency", shopItemService.getCurrency());
    return "more-filters";
  }

  @GetMapping(value ="/more-filters/{type}")
  public String moreFilters(Model model, @PathVariable(required = false) String type) {
    model.addAttribute("list", shopItemService.getType(type));
    model.addAttribute("format", "table");
    model.addAttribute("currency", shopItemService.getCurrency());
    return "more-filters";
  }


  @GetMapping(value ="/price-in-euro")
  public String priceInEur(Model model) {
    model.addAttribute("list", shopItemService.getPriceInEur());
    model.addAttribute("format", "table");
    model.addAttribute("currency", shopItemService.getCurrency());
    return "more-filters";
  }

  @GetMapping(value ="/original-currency")
  public String priceInCzk(Model model) {
    model.addAttribute("list", shopItemService.getPriceInCzk());
    model.addAttribute("format", "table");
    model.addAttribute("currency", shopItemService.getCurrency());
    return "more-filters";
  }

  @GetMapping(value ="/filter-by-price")
  public String searchPriceExactly(Model model,@RequestParam("type") String typeSearch, @RequestParam("price") Double price) {

    model.addAttribute("list", shopItemService.getSearchPrice(price, typeSearch));
    model.addAttribute("format", "table");
    model.addAttribute("currency", shopItemService.getCurrency());
    return "more-filters";
  }



}
