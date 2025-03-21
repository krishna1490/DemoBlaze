package org.krishnaIT.pages;

public class CheckPalindrome {
    public boolean VerifyPalindrome(String input) {
        String s = input;
        int stringLength = s.length();
        if (stringLength > 0) {
            for (int i = 0, j = stringLength - 1; i < stringLength / 2; i++, j--) {
                if (s.charAt(i) != s.charAt(j))
                    return false;
            }
            return true;
        } else
            return false;
    }
}