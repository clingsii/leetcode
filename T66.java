package com.lc.leetcode;

/**
 * Created by caoling on 16/6/7.
 */
public class T66 {

    public static int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        } else {
            digits[digits.length - 1] = 0;
            for (int j = digits.length - 2; j >= 0; j--) {
                if (digits[j] != 9) {
                    digits[j]++;
                    return digits;
                } else {
                    digits[j] = 0;
                }
            }
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        }
    }

    public static void main(String[] args) {
        int[] digits = {8,9,9,9};
        for (int i : plusOne(digits)) {
            System.out.print(i + " ");
        }
    }
}
