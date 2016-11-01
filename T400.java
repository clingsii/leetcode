package com.lc.leetcode;

/**
 * Created by caoling on 2016/11/1.
 * <p>
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * <p>
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 2^31).
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 3
 * <p>
 * Output:
 * 3
 * Example 2:
 * <p>
 * Input:
 * 11
 * <p>
 * Output:
 * 0
 * <p>
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 */
public class T400 {

    public static int findNthDigit(int n) {
        if (n <= 9) {
            return n;
        }
        long total = 0;
        long total1 = 0;
        int order = 1;
        long power10 = 1;
        while (total < n) {
            total1 = total;
            total += 9 * order * power10;
            if (total >= n) {
                break;
            }
            power10 *= 10;
            order++;
        }
        n -= total1;

        int offset = n % order == 0 ? n / order - 1 : n / order;

        long number = power10 + offset;
        n -= offset * order;

        String digit = String.valueOf(("" + number).charAt(n - 1));

        return Integer.valueOf(digit);
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(1000000000));
    }
}
