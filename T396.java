package com.lc.leetcode;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.stream.IntStream;

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
 * <p/>
 * <p/>
 * Solution:
 * F(k)-F(k-1) = Sum(B(k)) - N*F(n-1)
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

    public static int maxRotateFunction1(int[] A) {

        if (A.length < 20) {
            return maxRotateFunction(A);
        }

        int cores = Runtime.getRuntime().availableProcessors();

        int sumA = 0;

        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }

        final int sumB = sumA;
        int length = A.length % cores == 0 ? A.length / cores : A.length / cores  + 1;

        return IntStream.range(0, cores).parallel().map(i -> {

            int start = i * length;
            int end = (i + 1) * length;
            if (end > A.length) {
                end = A.length;
            }

            int last = getB(start, A);
            int max = last;

            for (int j = start; j < end; j++) {
                int pos = (A.length + start - j) % A.length;
                int temp = last + sumB - A.length * A[pos];
                if (temp > max) {
                    max = temp;
                }
                last = temp;
            }
            return max;
        }).max().getAsInt();

    }

    public static int getB(int offset, int[] A) {
        int sumA = 0;
        for (int i = 0; i < A.length; i++) {
            int pos = (A.length + i - offset) % A.length;
            sumA += i * A[pos];
        }
        return sumA;
    }


    public static void main(String[] args) throws Exception {

//        int[] A = {4, 3, 2, 6};
//
//        for (int i = 0; i < A.length; i++) {
//            System.out.println(i + " :  " + getB(i, A));
//        }

        String dataFile = "/Users/caoling/Desktop/testData.txt";
        String s = FileUtils.readFileToString(new File(dataFile));

        String[] ss = s.split(",");
        int[] A = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            A[i] = Integer.valueOf(ss[i]);
        }


        long start = System.nanoTime();
        System.out.println(maxRotateFunction(A));
        long elapse = System.nanoTime() - start;
        System.out.println("Take time: " + elapse);


        long start1 = System.nanoTime();
        System.out.println(maxRotateFunction1(A));
        long elapse1 = System.nanoTime() - start1;
        System.out.println("Take time: " + elapse1);

    }
}
