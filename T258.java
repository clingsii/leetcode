package com.lc.leetcode;

/**
 * Created by caoling on 16/6/4.
 */
public class T258 {

    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int n = num % 9;
        if (n == 0){
            return 9;
        }
        return n;
    }


    public static void main(String[] args) {
        System.out.println( 12 & 8);
//        System.out.println(addDigits(123124214));
    }
}
