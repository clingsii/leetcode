package com.lc.leetcode;

/**
 * Created by caoling on 2016/11/4.
 * <p>
 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class T415 {

    public static String addStrings(String num1, String num2) {
        if ("0".equals(num1)) {
            return num2;
        }
        if ("0".equals(num2)) {
            return num1;
        }

        int minLength = num1.length() < num2.length() ? num1.length() : num2.length();

        StringBuilder result = new StringBuilder();

        boolean overflow = false;

        int char0 = (int) '0';

        for (int i = 0; i < minLength; i++) {
            int c1 = num1.charAt(num1.length() - i - 1) - char0;
            int c2 = num2.charAt(num2.length() - i - 1) - char0;
            int sum = c1 + c2;
            if (overflow) {
                sum++;
                overflow = false;
            }
            if (sum >= 10) {
                overflow = true;
                int newSum = sum - 10;
                result.append(newSum);
            } else {
                result.append(sum);
            }

        }
        if (num1.length() > minLength) {
            for (int i = 0; i < num1.length() - minLength; i++) {
                int c = num1.charAt(num1.length() - minLength - i - 1) - char0;
                if (overflow) {
                    c++;
                    overflow = false;
                }
                if (c == 10) {
                    overflow = true;
                    result.append('0');
                } else {
                    result.append(c);
                }
            }
        } else if (num2.length() > minLength) {
            for (int i = 0; i < num2.length() - minLength; i++) {
                int c = num2.charAt(num2.length() - minLength - i - 1) - char0;
                if (overflow) {
                    c++;
                    overflow = false;
                }
                if (c == 10) {
                    overflow = true;
                    result.append('0');
                } else {
                    result.append(c);
                }
            }
        }

        if (overflow) {
            result.append('1');
        }
        return result.reverse().toString();
    }


    public static void main(String[] args) {
        String num1 = "109";
        String num2 = "1901";
        System.out.println(addStrings(num2, num1));
    }
}
