package org.krishnaIT;
import org.krishnaIT.pages.CheckPalindrome;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PalindromeTest {
    CheckPalindrome checkPalindrome;

    @BeforeMethod
    public void setup(){
        CheckPalindrome checkPalindrome = new CheckPalindrome();
    }


    @Test
    public void checkLowerCase(){
       boolean result = checkPalindrome.VerifyPalindrome("madam");
        Assert.assertTrue(result);
    }

    @Test
    public void checkUpperCase(){
        boolean result = checkPalindrome.VerifyPalindrome("MADAM");
        Assert.assertTrue(result);
    }

    @Test
    public void checkCombinationCase(){
        boolean result = checkPalindrome.VerifyPalindrome("MADam");
        Assert.assertFalse(result);
    }

    @Test
    public void checkSpecialCase(){
        boolean result = checkPalindrome.VerifyPalindrome("M@D@m");
        Assert.assertFalse(result);
    }
}
