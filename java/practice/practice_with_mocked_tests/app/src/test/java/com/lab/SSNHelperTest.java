package com.lab;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SSNHelperTest {
  static SSNHelper sut = new SSNHelper();
  // static BuggySSNHelperAllowDayUpTo30 sut = new BuggySSNHelperAllowDayUpTo30();
  // static BuggySSNHelperAllowMonth0 sut = new BuggySSNHelperAllowMonth0();
  // static BuggySSNHelperIncorrectFormat sut = new BuggySSNHelperIncorrectFormat(); // Always true
  // static BuggySSNHelperIncorrectFormatFalse sut = new BuggySSNHelperIncorrectFormatFalse(); // Always false
  // static BuggySSNHelperMessyLuhn sut = new BuggySSNHelperMessyLuhn();
  // static BuggySSNHelperWrongLength sut = new BuggySSNHelperWrongLength();

  @Test
  void isValidDay_Should_Return_True_For_Valid_Input() {
    String validDay = "31";
    boolean actual = sut.isValidDay(validDay);
    assertTrue(actual);
  }

  @Test
  void isValidMonth_Should_Return_False_For_Invalid_Input() {
    String invalidMonth = "0";
    boolean actual = sut.isValidMonth(invalidMonth);
    assertFalse(actual);
  }

  @Test
  void isCorrectFormat_Should_Return_True_For_Valid_Input() {
    String validSSN = "850913-2398";
    boolean actual = sut.isCorrectFormat(validSSN);
    assertTrue(actual);
  }

  @Test
  void isCorrectFormat_Should_Return_False_For_Invalid_Input() {
    String ssnHyphenWrongPlace = "8509-132398";
    boolean actual = sut.isCorrectFormat(ssnHyphenWrongPlace);
    assertFalse(actual);
  }

  @Test
  void luhnIsCorrect_Should_Return_True_For_Valid_Input() {
    String validSSN = "850913-2398";
    boolean actual = sut.luhnIsCorrect(validSSN);
    assertTrue(actual);
  }

  @Test
  void isCorrectLength_Should_Return_False_For_Invalid_Input() {
    String ssnTooLong = "850913-23987";
    boolean actual = sut.isCorrectLength(ssnTooLong);
    assertFalse(actual);
  }
}
