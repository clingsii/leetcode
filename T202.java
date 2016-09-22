package com.lc.leetcode;

/**
 * Created by caoling on 16/6/6.
 */
public class T202 {
    public static boolean isHappy(int n) {
        while (true) {
            if (n == 1 || n == 10 || n == 100 || n == 1000) {
                return true;
            }
            if (n == (int) Math.pow(10, (int) Math.log10(n))) {
                return true;
            }
            if (n < 100) {
                if (n == 7 || n == 70 || n == 49 || n == 94 || n== 97|| n== 79 || n == 13 || n == 31 || n == 86 || n == 68 ||
                        n == 23 || n == 32 || n == 82 || n == 28
                        || n == 44 || n == 19 || n == 91) {
                    return true;
                } else {
                    return false;
                }
            }
            n = getSum(n);
        }

    }

    public static int getSum(int n) {
        int sum = 0;
        while (n >= 10) {
            int r = n % 10;
            sum += r * r;
            n /= 10;
        }
        sum += n * n;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getSum(100));

    }
}
