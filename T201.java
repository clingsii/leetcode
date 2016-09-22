package com.lc.leetcode;

/**
 * Created by caoling on 16/6/6.
 */
public class T201 {
    public static int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        int t = m & n;
        if (t == 0) {
            return 0;
        }
        if ((n & (n - 1)) == 0) {
            return 0;
        }


        int diff = n - m;
        if (t < diff) {
            return 0;
        }
        if (diff == 1) {
            return t;
        }
        if (diff == 2) {
            return t & (m + 1);
        }
        int p = 1;
        int pow = 0;
        while (p <= diff) {
            t = t >> 1;
            if (t == 0) {
                return 0;
            }
            p = p << 1;
            pow++;
        }
        return t << pow;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(11, 14));
    }
}
