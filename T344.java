package com.lc.leetcode;

/**
 * Created by ling cao on 16/6/3.
 */
public class T344 {

    public static String reverseString(String s) {
        char[] temp = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        for (left = 0; left < right; left++, right--) {
            char t = temp[left];
            temp[left] = temp[right];
            temp[right] = t;
        }
        return String.valueOf(temp);
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseString(s));
    }
}
