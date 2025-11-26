package com.lab;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SSNHelperTest {
  // static BuggySSNHelperAllowDayUpTo30 helper = new BuggySSNHelperAllowDayUpTo30();
  // static BuggySSNHelperAllowMonth0 helper = new BuggySSNHelperAllowMonth0();
  // static BuggySSNHelperIncorrectFormat helper = new BuggySSNHelperIncorrectFormat(); // Always true
  // static BuggySSNHelperIncorrectFormatFalse helper = new BuggySSNHelperIncorrectFormatFalse(); // Always false
  // static BuggySSNHelperMessyLuhn helper = new BuggySSNHelperMessyLuhn();
   static BuggySSNHelperWrongLength helper = new BuggySSNHelperWrongLength();

  @Test
  void isValidDay_Should_Return_True_For_Valid_Input() {
    String day = "31";
    assertTrue(helper.isValidDay(day));
  }

  @Test
  void isValidMonth_Should_Return_False_For_Invalid_Input() {
    String month = "0";
    assertFalse(helper.isValidMonth(month));
  }

  @Test
  void isCorrectFormat_Should_Return_True_For_Valid_Input() {
    String input = "850913-2398";
    assertTrue(helper.isCorrectFormat(input));
  }

  @Test
  void isCorrectFormat_Should_Return_False_For_Invalid_Input() {
    String input = "8509-132398";
    assertFalse(helper.isCorrectFormat(input));
  }

  @Test
  void luhnIsCorrect_Should_Return_True_For_Valid_Input() {
    String input = "850913-2398";
    assertTrue(helper.luhnIsCorrect(input));
  }

  @Test
  void isCorrectLength_Should_Return_False_For_Invalid_Input() {
    String ssnTooLong = "850913-23987";
    assertFalse(helper.isCorrectLength(ssnTooLong));
  }
}
