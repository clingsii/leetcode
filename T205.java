package com.lc.leetcode;

/**
 * Created by caoling on 16/6/7.
 */
public class T205 {

    public static boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        char[] sub = new char[256];
        char[] rsub = new char[256];

        char a;
        char b;

        for (int i = 0; i < s.length(); i++) {
            a = s.charAt(i);
            b = t.charAt(i);
            int aindex = (int) a;
            int bindex = (int) b;
            char old = rsub[bindex];
            if (old != '\0') {
                if (old == a) {
                    continue;
                } else {
                    return false;
                }
            } else {
                char rold = sub[aindex];
                if (rold != '\0') {
                    if (rold != b) {
                        return false;
                    } else {
                        continue;
                    }

                } else {
                    rsub[bindex] = a;
                    sub[aindex] = b;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "aa";
        String t = "ab";
        System.out.println(isIsomorphic(s, t));
    }

}
