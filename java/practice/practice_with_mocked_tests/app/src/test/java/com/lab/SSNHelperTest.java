package com.lab;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SSNHelperTest {
  static SSNHelper helper = new SSNHelper();
  // static BuggySSNHelperAllowDayUpTo30 helper = new BuggySSNHelperAllowDayUpTo30();
  // static BuggySSNHelperAllowMonth0 helper = new BuggySSNHelperAllowMonth0();
  // static BuggySSNHelperIncorrectFormat helper = new BuggySSNHelperIncorrectFormat(); // Always true
  // static BuggySSNHelperIncorrectFormatFalse helper = new BuggySSNHelperIncorrectFormatFalse(); // Always false
  // static BuggySSNHelperMessyLuhn helper = new BuggySSNHelperMessyLuhn();
  // static BuggySSNHelperWrongLength helper = new BuggySSNHelperWrongLength();

  @Test
  void isValidDay_Should_Return_True_For_Valid_Input() {
    String validDay = "31";
    boolean actual = helper.isValidDay(validDay);
    assertTrue(actual);
  }

  @Test
  void isValidMonth_Should_Return_False_For_Invalid_Input() {
    String invalidMonth = "0";
    boolean actual = helper.isValidMonth(invalidMonth);
    assertFalse(actual);
  }

  @Test
  void isCorrectFormat_Should_Return_True_For_Valid_Input() {
    String validSSN = "850913-2398";
    boolean actual = helper.isCorrectFormat(validSSN);
    assertTrue(actual);
  }

  @Test
  void isCorrectFormat_Should_Return_False_For_Invalid_Input() {
    String ssnHyphenWrongPlace = "8509-132398";
    boolean actual = helper.isCorrectFormat(ssnHyphenWrongPlace);
    assertFalse(actual);
  }

  @Test
  void luhnIsCorrect_Should_Return_True_For_Valid_Input() {
    String validSSN = "850913-2398";
    boolean actual = helper.luhnIsCorrect(validSSN);
    assertTrue(actual);
  }

  @Test
  void isCorrectLength_Should_Return_False_For_Invalid_Input() {
    String ssnTooLong = "850913-23987";
    boolean actual = helper.isCorrectLength(ssnTooLong);
    assertFalse(actual);
  }
}
