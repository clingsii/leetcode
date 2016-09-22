package com.lc.leetcode;

/**
 * Created by caoling on 16/6/5.
 */
public class T326 {

    public static boolean isPowerOfThree(int n) {
        while (n >= 9) {
            if (n % 3 > 0) {
                return false;
            }
            n /= 3;
        }
        if (n == 1 || n == 3 || n == 9) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
    }
}

