package com.lc.leetcode;

/**
 * Created by caoling on 2016/11/4.
 * <p>
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 * <p>
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class T383 {

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        int[] data = new int[(int) 'z' + 1];
        for (char c : magazine.toCharArray()) {
            data[(int) c]++;
        }
        for (char c : ransomNote.toCharArray()) {
            int p = (int) c;
            if (data[p] == 0) {
                return false;
            } else {
                data[p]--;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        String r = "aa";
        String m = "aab";
        System.out.println(canConstruct(r, m));

    }
}
