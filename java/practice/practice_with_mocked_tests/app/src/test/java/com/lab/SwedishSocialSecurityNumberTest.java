package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SwedishSocialSecurityNumberTest {
    private SSNHelper mockHelper;
    private static final String VALID_SSN = "850913-2398";

    private SSN getSSN(String stringInput) throws Exception {
        // Choose implementation to test

         return new SwedishSocialSecurityNumber(stringInput, mockHelper);
        // return new BuggySwedishSocialSecurityNumberNoLenCheck(stringInput, mockHelper);
        // return new BuggySwedishSocialSecurityNumberNoLuhn(stringInput, mockHelper);
        // return new BuggySwedishSocialSecurityNumberNoTrim(stringInput, mockHelper);
        // return new BuggySwedishSocialSecurityNumberWrongYear(stringInput, mockHelper);
        // return new MyCustomBug1(stringInput, mockHelper);
        // return new MyCustomBug2(stringInput, mockHelper);
    }

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
        getSSN(VALID_SSN);

        verify(mockHelper).isCorrectLength(VALID_SSN);
    }

    @Test
    void constructor_Should_Check_Input_Against_Luhn_Algorithm() throws Exception {
        getSSN(VALID_SSN);
        
        verify(mockHelper).luhnIsCorrect(VALID_SSN);
    }

    @Test
    void constructor_Should_Trim_Input() throws Exception {
        String ssnWithWhitespace = "850913-2398 ";

        SSN sut = getSSN(ssnWithWhitespace);

        String expected = "850913-2398";
        String actual = sut.getSSN();

        assertEquals(expected, actual);
    }
    
    @Test
    void getYear_Should_Return_Correct_Numbers() throws Exception {
        SSN sut = getSSN(VALID_SSN);

        String expected = "85";
        String actual = sut.getYear();

        assertEquals(expected, actual);
    }
    
    @Test
    void constructor_Should_Check_For_Correct_Format() throws Exception {
        String ssnIncorrectHyphen = "8509-132398";

        getSSN(ssnIncorrectHyphen);

        verify(mockHelper).isCorrectFormat(ssnIncorrectHyphen);
    }

    @Test
    void constructor_Should_Check_For_Valid_Month() throws Exception {
        getSSN(VALID_SSN);

        verify(mockHelper).isValidMonth(anyString());
    }
}