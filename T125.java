package com.lc.leetcode;

/**
 * Created by caoling on 16/6/6.
 */
public class T125 {
    public static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        s = s.toLowerCase();
        int h = 0;
        int t = s.length() - 1;
        while (h < t) {
            int hco = (int)s.charAt(h);
            while (!isDigitalOrAlphabeta(hco)) {
                h++;
                hco = (int)s.charAt(h);
                if (h >= t) {
                    return true;
                }
            }
            int tco = (int)s.charAt(t);
            while (!isDigitalOrAlphabeta(tco)) {
                t--;
                tco = (int)s.charAt(t);
                if (h >= t) {
                    return true;
                }
            }
            if (hco == tco) {
                h++;
                t--;
                continue;
            } else {
                return false;
            }

        }
        return true;
    }

    public static boolean isDigitalOrAlphabeta(int order) {
        if (order >= 48 && order <= 57) {
            return true;
        }
        if (order >= 97 && order <= 122) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = ".,";
        System.out.println(isPalindrome(s));
    }
}
