package com.greenfoxacademy.dependencies.usefulutilities.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilityServiceTest {

  UtilityService utilityService;

  @BeforeEach
  public void setup() {
    utilityService = new UtilityService();
  }

  @Test
  @DisplayName("Should return true for correct email")
  void shouldReturnTrueForCorrectEmail() {
    String email = "roman.kerda@gmail.com";
    assertTrue(utilityService.isEmail(email));
  }

  @Test
  @DisplayName("Should return false for incorrect email")
  void shouldReturnFalseForIncorrectEmail() {
    String email = "roman.kerda_gmail.com";
    assertFalse(utilityService.isEmail(email));
  }

  @Test
  @DisplayName("Should return correct result after encoding")
  void shouldReturnCorrectResultAfterEncoding() {
    assertEquals("bCd", utilityService.caesar("aBc", 1));
  }



}