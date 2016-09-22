package com.lc.leetcode;

/**
 * Created by caoling on 16/6/6.
 */
public class T7 {

    public static int reverse(int x) {
        boolean negative = false;
        if (x == Integer.MIN_VALUE) {
             return 0;
        }
        if (x < 0) {
            negative = true;
            x = Math.abs(x);
        }

        if (x < 10) {
            if (negative) {
                return -x;
            }
            return x;
        }
        StringBuilder sb;
        sb = new StringBuilder(x + "");
        long value = Long.valueOf(sb.reverse().toString());
        if (value > Integer.MAX_VALUE) {
            return 0;
        }
        if (negative) {
            return -(int) value;
        }
        return (int) value;


    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
}
