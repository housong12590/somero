package com.somero.deploy.utils;

public class StringUtils {

    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }

    public static boolean isNotEmpty(String text) {
        return !isEmpty(text);
    }

    public static boolean equals(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return false;
        }
        return text1.equals(text2);
    }
}
