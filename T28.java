package com.lc.leetcode;

/**
 * Created by caoling on 16/7/5.
 */
public class T28 {

    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        if (needle.length() == 0) {
            return 0;
        }

        char[] hchars = haystack.toCharArray();
        char[] nchars = needle.toCharArray();

        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if ((i+j) >= haystack.length()) {
                    return -1;
                }
                System.out.print(nchars[j] + "  " + hchars[i + j] + " ");
                if (nchars[j] == hchars[i + j]) {
                    if (j == (needle.length() - 1)) {
                        return i;
                    } else {
                        continue;
                    }
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "";
        String needle = "";

        System.out.println();

        System.out.println(strStr(haystack, needle));
    }
}