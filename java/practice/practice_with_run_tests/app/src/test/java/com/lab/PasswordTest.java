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
         return (IPassword) new Password(s);
        // return (IPassword) new BugDoesNotTrim(s);
        // return (IPassword) new BugToShortPassword(s); 
        // return (IPassword) new BugVeryShort(s);
        // return (IPassword) new BugWrongExceptionMessage(s);
        // return (IPassword) new BugMissingPasswordLengthCheck(s);
        // return (IPassword) new BugMissingNumberCheck(s);
        // return (IPassword) new BugIsPasswordSameAlwaysTrue(s);
        // return (IPassword) new BugWrongHashingAlgorithm(s);
    }

    @Test
    public void shouldAlwaysPass() throws Exception {
        assertTrue(true);
    }

    @Test
    public void constructor_Should_Trim_Whitespace_From_Password() throws Exception {
        String pwdString = " abcdefg12345 ";
        IPassword password = getPassword(pwdString);
        int expected = simpleHash(pwdString.trim());
        int actual = password.getPasswordHash();
        
        assertEquals(expected, actual);
    }

    private int simpleHash(String input) {
        int hash = 7;
        for (int i = 0; i < input.length(); i++) {
            hash = hash * 31 + input.charAt(i);
        }
        return hash;
    }

    @Test
    public void constructor_Should_Throw_Exception_For_Short_Password() throws Exception {
        String pwdString = "abcde123456";
        
        assertThrows(Exception.class, () -> {
            getPassword(pwdString);
        });
    }

    @Test
    public void constructor_Should_Throw_Exception_For_Password_Without_Number() {
        String pwdString = "abcdefghijkl";

        assertThrows(Exception.class, () -> {
            getPassword(pwdString);
        });
    }
    
    @Test
    public void simpleHash_Should_Return_Same_Hash_For_Same_String() throws Exception {
        String pwdString = "abcdefghijk1";
        IPassword password = getPassword(pwdString);
        int expected = simpleHash(pwdString);
        int actual = password.getPasswordHash();

        assertEquals(expected, actual);
    }
    
    @Test
    public void isPassWordSame_Should_Return_False_For_Different_Passwords() throws Exception {
        String pwdString1 = "abcdefghjkl1";
        String pwdString2 = "abcdefghjkl2";
        IPassword sut1 = getPassword(pwdString1);
        IPassword sut2 = getPassword(pwdString2);

        assertFalse(sut1.isPasswordSame(sut2));
    }

    @Test
    public void isPassWordSame_Should_Return_True_For_Same_Passwords() throws Exception {
        String pwdString = "abcdefghjkl1";
        IPassword sut1 = getPassword(pwdString);
        IPassword sut2 = getPassword(pwdString);

        assertTrue(sut1.isPasswordSame(sut2));
    }
    
    @Test
    public void constructor_Should_Show_Correct_Error_Message_For_Short_Password() {
        String pwdString = "abc123";
        Exception exception = assertThrows(Exception.class, () -> {
            getPassword(pwdString);
        });

        String expected = "To short password";
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

}
