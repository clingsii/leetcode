package com.lc.leetcode;

/**
 * Created by caoling on 2016/11/3.
 * <p>
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * <p>
 * Example:
 * <p>
 * Input:
 * "abccccdd"
 * <p>
 * Output:
 * 7
 * <p>
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class T409 {
    public static int longestPalindrome(String s) {
        int[] data = new int[60];
        // in ascii table, A is 65 and z is 122, so using a larger array can reduce the computation time
        for (int i = 0; i < 60; i++) {
            data[i] = 0;
        }
        int startPos = (int) 'A';
        for (char c : s.toCharArray()) {
            int pos = (int) c - startPos;
            data[pos]++;
        }
        boolean hasOdd = false;
        int total = 0;
        for (int d : data) {
            if (d > 0) {
                if (d % 2 == 0) {
                    total += d;
                } else {
                    total += (d - 1);
                    hasOdd = true;
                }
            }
        }
        if (hasOdd) {
            total++;
        }
        return total;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
}
