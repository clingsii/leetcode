package com.lc.leetcode;

/**
 * url: https://leetcode.com/problems/rotate-function/
 * <p/>
 * Given an array of integers A and let n to be its length.
 * <p/>
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
 * <p/>
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * <p/>
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 * <p/>
 * Note:
 * n is guaranteed to be less than 105.
 * <p/>
 * Created by Ling Cao on 2016/9/24.
 *
 *
 * Solution:
 * F(k)-F(k-1) = Sum(B(k)) - N*Bk(n-1)
 *
 */
public class T396 {

    public static int maxRotateFunction(int[] A) {

        if (A == null || A.length == 0) {
            return 0;
        }

        int totalA = 0;
        int sumA = 0;
        for (int i = 0; i < A.length; i++) {
            totalA += A[i];
            sumA += i * A[i];
        }

        int max = sumA;
        int last = sumA;

        for (int i = 1; i < A.length; i++) {
            int temp = last + totalA - A.length * A[A.length - i];
            if (temp > max) {
                max = temp;
            }
            last = temp;
        }
        return max;

    }


    public static void main(String[] args) throws Exception {

        int[] A = {4, 3, 2, 6};

        System.out.println(maxRotateFunction(A));
    }
}
