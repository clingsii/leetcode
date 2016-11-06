package com.lc.leetcode;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * Created by caoling on 2016/11/6.
 * <p>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class T70 {
    public static int climbStairs(int n) {

        int[] data = new int[n + 1];

        if (n <= 3) {
            return n;
        } else {

            data[1] = 1;
            data[2] = 2;
            data[3] = 3;
            for (int i = 4; i < n + 1; i++) {
                data[i] = data[i - 1] + data[i - 2];
            }
            return data[n];
        }
    }

    public static void main(String[] args) {
        Stopwatch stopwatch = Stopwatch.createUnstarted();
        stopwatch.start();
        System.out.println(climbStairs(44));
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
