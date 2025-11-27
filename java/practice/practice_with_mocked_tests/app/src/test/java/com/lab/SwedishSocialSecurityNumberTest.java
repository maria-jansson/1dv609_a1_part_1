package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SwedishSocialSecurityNumberTest {
    private SSNHelper mockHelper;

    @BeforeEach
    public void setUp() {
        mockHelper = mock(SSNHelper.class);
        when(mockHelper.isCorrectLength(anyString())).thenReturn(true);
        when(mockHelper.isCorrectFormat(anyString())).thenReturn(true);
        when(mockHelper.isValidMonth(anyString())).thenReturn(true);
        when(mockHelper.isValidDay(anyString())).thenReturn(true);
        when(mockHelper.luhnIsCorrect(anyString())).thenReturn(true);
    }

    @Test
    void constructor_Should_Check_For_Input_Length() throws Exception {
        String validSSN = "850913-2398";

        // SwedishSocialSecurityNumber sut = new SwedishSocialSecurityNumber(validSSN, mockHelper);
        BuggySwedishSocialSecurityNumberNoLenCheck sut = new BuggySwedishSocialSecurityNumberNoLenCheck(validSSN, mockHelper);

        verify(mockHelper).isCorrectLength(validSSN);
    }

    @Test
    void constructor_Should_Check_Input_Against_Luhn_Algorithm() throws Exception {
        String validSSN = "850913-2398";

        // SwedishSocialSecurityNumber sut = new SwedishSocialSecurityNumber(validSSN, mockHelper);
        BuggySwedishSocialSecurityNumberNoLuhn sut = new BuggySwedishSocialSecurityNumberNoLuhn(validSSN, mockHelper);
        
        verify(mockHelper).luhnIsCorrect(validSSN);
    }

    @Test
    void constructor_Should_Trim_Input() throws Exception {
        String ssnWithWhitespace = "850913-2398 ";

        // SwedishSocialSecurityNumber sut = new SwedishSocialSecurityNumber(ssnWithWhitespace, mockHelper);
        BuggySwedishSocialSecurityNumberNoTrim sut = new BuggySwedishSocialSecurityNumberNoTrim(ssnWithWhitespace, mockHelper);

        String expected = "850913-2398";
        String actual = sut.getSSN();

        assertEquals(expected, actual);
    }
    
    @Test
    void getYear_Should_Return_Correct_Numbers_For_Year() throws Exception {
        String validSSN = "850913-2398";

        // SwedishSocialSecurityNumber sut = new SwedishSocialSecurityNumber(validSSN, mockHelper);
        BuggySwedishSocialSecurityNumberWrongYear sut = new BuggySwedishSocialSecurityNumberWrongYear(validSSN, mockHelper);

        String expected = "85";
        String actual = sut.getYear();

        assertEquals(expected, actual);
    }
    
    @Test
    void constructor_Should_Check_For_Correct_Format() throws Exception {
        String ssnIncorrectHyphen = "8509-132398";

        // SwedishSocialSecurityNumber sut = new SwedishSocialSecurityNumber(ssnIncorrectHyphen, mockHelper);
        MyCustomBug1 sut = new MyCustomBug1(ssnIncorrectHyphen, mockHelper);

        verify(mockHelper).isCorrectFormat(ssnIncorrectHyphen);
    }

    @Test
    void constructor_Should_Check_For_Valid_Month() throws Exception {
        String ssnIncorrectMonth = "851313-2398";

        // SwedishSocialSecurityNumber sut = new SwedishSocialSecurityNumber(ssnIncorrectMonth, mockHelper);
        MyCustomBug2 sut = new MyCustomBug2(ssnIncorrectMonth, mockHelper);

        verify(mockHelper).isValidMonth(ssnIncorrectMonth);
    }
}