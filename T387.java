package com.lc.leetcode;

/**
 * Created by caoling on 2016/11/4.
 * <p>
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class T387 {

    public static int firstUniqChar(String s) {

        int[] data = new int[(int) 'z' + 1];
        for (char c : s.toCharArray()) {
            data[(int) c]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (data[(int) c] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

}
