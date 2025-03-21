package org.krishnaIT.pages;

public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty())
            return false;

        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Result is "+PalindromeChecker.isPalindrome("m  d!m"));
        }
    }
