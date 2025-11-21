package com.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Test class for Password implementations.
 * 
 * To test different buggy versions, simply uncomment the corresponding
 * getPassword() method and comment out the others.
 * 
 * Available implementations:
 * - Password: Correct implementation
 * - BugDoesNotTrim: Does not trim whitespace
 * - BugToShortPassword: Allows passwords shorter than 12 characters
 * - BugVeryShort: Allows way to short passwords
 * - BugWrongExceptionMessage: Wrong exception message for short passwords
 * - BugMissingPasswordLengthCheck: Does not throw exception for short passwords
 * - BugMissingNumberCheck: Does not throw exception if password lacks a number
 * - BugIsPasswordSameAlwaysTrue: isPasswordSame always returns true
 * - BugWrongHashingAlgorithm: Wrong hashing algorithm
 */

public class PasswordTest {
    private IPassword getPassword(String s) throws Exception {
        // return (IPassword) new Password(s);
        // return (IPassword) new BugDoesNotTrim(s);
        // return (IPassword) new BugToShortPassword(s); 
        // return (IPassword) new BugVeryShort(s);
        // return (IPassword) new BugWrongExceptionMessage(s);
        // return (IPassword) new BugMissingPasswordLengthCheck(s);
        // return (IPassword) new BugMissingNumberCheck(s);
        // return (IPassword) new BugIsPasswordSameAlwaysTrue(s);
        // return (IPassword) new BugWrongHashingAlgorithm(s);
         return (IPassword) new MyCustomBug(s);
    }

    @Test
    public void shouldAlwaysPass() throws Exception {
        assertTrue(true);
    }

    @Test
    public void constructor_Should_Trim_Whitespace_From_Password() throws Exception {
        String whiteSpacePassword = " abcdefg12345 ";
        IPassword testObject = getPassword(whiteSpacePassword);
        int expected = simpleHash(whiteSpacePassword.trim());
        int actual = testObject.getPasswordHash();
        
        assertEquals(expected, actual);
    }

    private int simpleHash(String input) {
        int hashValue = 7;
        int hashMultiplier = 31;
        for (int i = 0; i < input.length(); i++) {
            hashValue = hashValue * hashMultiplier + input.charAt(i);
        }
        return hashValue;
    }

    @Test
    public void constructor_Should_Throw_Exception_For_Short_Password() throws Exception {
        String shortPassword = "abcde123456";
        
        assertThrows(Exception.class, () -> {
            getPassword(shortPassword);
        });
    }

    @Test
    public void constructor_Should_Throw_Exception_For_Password_Without_Number() {
        String missingNumberPassword = "abcdefghijkl";

        assertThrows(Exception.class, () -> {
            getPassword(missingNumberPassword);
        });
    }
    
    @Test
    public void getPasswordHash_Should_Return_Same_Hash_For_Same_String() throws Exception {
        String validPassword = "abcdefghijk1";
        IPassword testObject = getPassword(validPassword);
        int expected = simpleHash(validPassword);
        int actual = testObject.getPasswordHash();

        assertEquals(expected, actual);
    }
    
    @Test
    public void isPassWordSame_Should_Return_False_For_Different_Passwords() throws Exception {
        String validPassword1 = "abcdefghjkl1";
        String validPassword2 = "abcdefghjkl2";
        IPassword testObject1 = getPassword(validPassword1);
        IPassword testObject2 = getPassword(validPassword2);

        assertFalse(testObject1.isPasswordSame(testObject2));
    }
    
    @Test
    public void constructor_Should_Show_Correct_Error_Message_For_Short_Password() {
        String shortPassword = "abc123";
        Exception exception = assertThrows(Exception.class, () -> {
            getPassword(shortPassword);
        });

        String expected = "To short password";
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

}
