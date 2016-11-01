package com.lc.leetcode;

import org.jetbrains.annotations.Contract;

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

        while (total < n) {
            total1 = total;
            total = totalN(order, power10(order));
            if (total >= n) {
                break;
            }
            order++;
        }

        n -= total1;

        int offset = n % order == 0 ? n / order - 1 : n / order;

        long number = power10(order - 1) + offset;
        n -= offset * order;

        String digit = String.valueOf(("" + number).charAt(n - 1));

        return Integer.valueOf(digit);
    }

    @Contract(pure = true)
    private static long totalN(int n, long power10) {
        return n * power10 - (power10 - 1) / 9;
    }

    private static long[] power10array = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000
            ,10000000000l, 100000000000l, 1000000000000l, 10000000000000l,
            100000000000000l, 1000000000000000l, 10000000000000000l, 100000000000000000l};

    @Contract(pure = true)
    private static long power10(int n) {
        return power10array[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(100000000));

//        System.out.println(totalN(3, 1000));
    }
}
