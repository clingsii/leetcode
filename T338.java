package com.lc.leetcode;

/**
 * Created by caoling on 16/6/5.
 */
public class T338 {

    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        int pos = 1;
        result[0] = 0;
        for (int j = 1; j <= num; j++) {
            if ((j & (j - 1)) == 0) {
                result[j] = 1;
                pos = j;
            } else {
                result[j] = result[j - pos] + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i : countBits(16)) {
            System.out.print(i + " ");
        }
    }
}
