package com.lc.leetcode;

/**
 * Created by caoling on 16/6/7.
 */
public class T263 {
    public static boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        if ((num & (num - 1)) == 0) {
            return true;
        }
        while (num >= 10) {
            boolean d2 = num % 2 == 0;
            boolean d3 = num % 3 == 0;
            boolean d5 = num % 5 == 0;
            if (!d2 && !d3 && !d5) {
                return false;
            }
            if (d2) {
                num /= 2;
            }
            if (d3) {
                num /= 3;
            }
            if (d5) {
                num /= 5;
            }
        }
        if (num == 2 || num == 3 || num == 5 || num == 6 || num == 1
                || num == 4 || num == 8 || num == 9) {
            return true;
        }
        return false;
    }

}
