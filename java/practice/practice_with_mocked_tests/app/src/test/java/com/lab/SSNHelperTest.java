package com.lab;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SSNHelperTest {
  // static BuggySSNHelperAllowDayUpTo30 helper = new BuggySSNHelperAllowDayUpTo30();
   static BuggySSNHelperAllowMonth0 helper = new BuggySSNHelperAllowMonth0();
  // static BuggySSNHelperIncorrectFormat helper = new BuggySSNHelperIncorrectFormat();
  // static BuggySSNHelperIncorrectFormatFalse helper = new BuggySSNHelperIncorrectFormatFalse();
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
}
