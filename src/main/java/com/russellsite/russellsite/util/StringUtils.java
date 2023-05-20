package com.russellsite.russellsite.util;

public class StringUtils {

    public static String reverse(String s) {
        String reversedString = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversedString += s.charAt(i);
        }
        return reversedString;
    }

}
