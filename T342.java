package com.lc.leetcode;

/**
 * Created by caoling on 16/6/3.
 */
public class T342 {

    public static boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }

        if ((num & (num - 1)) > 0) {
            return false; // 先判断是否是 2 的 N 次方
        }
        if ((num & 0x55555555) > 0) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        int a = 4 >> 2;
        System.out.println(a);
        System.out.println(isPowerOfFour(1162261466));

    }
}
