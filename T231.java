package com.lc.leetcode;

/**
 * Created by caoling on 16/6/7.
 */
public class T231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0 ){
            return false;
        } else {
            return (n & (n-1)) == 0;
        }

    }
}
