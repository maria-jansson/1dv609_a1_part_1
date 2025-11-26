package com.lab;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SSNHelperTest {
  // static BuggySSNHelperAllowDayUpTo30 helper = new BuggySSNHelperAllowDayUpTo30();
  // static BuggySSNHelperAllowMonth0 helper = new BuggySSNHelperAllowMonth0();
  // static BuggySSNHelperIncorrectFormat helper = new BuggySSNHelperIncorrectFormat(); // Always true
   static BuggySSNHelperIncorrectFormatFalse helper = new BuggySSNHelperIncorrectFormatFalse(); // Always false
  // static BuggySSNHelperMessyLuhn helper = new BuggySSNHelperMessyLuhn();
  // static BuggySSNHelperWrongLength helper = new BuggySSNHelperWrongLength();

  @Test
  void isValidDay_Should_Return_True_For_Correct_Input() {
    String day = "31";
    assertTrue(helper.isValidDay(day));
  }

  @Test
  void isValidMonth_Should_Return_False_For_Incorrect_Input() {
    String month = "0";
    assertFalse(helper.isValidMonth(month));
  }

  @Test
  void isCorrectFormat_Should_Return_True_For_Correct_Input() {
    String input = "850624-2436";
    assertTrue(helper.isCorrectFormat(input));
  }

  @Test
  void isCorrectFormat_Should_Return_False_For_InCorrect_Input() {
    String input = "8506-242436";
    assertFalse(helper.isCorrectFormat(input));
  }
}
