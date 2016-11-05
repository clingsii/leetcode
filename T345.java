package com.lc.leetcode;

/**
 * Created by caoling on 2016/11/4.
 * <p>
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * Given s = "hello", return "holle".
 * <p>
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * <p>
 * Note:
 * The vowels does not include the letter "y".
 * <p>
 * Subscribe to see which companies asked this question
 */
public class T345 {

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();

        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            boolean isVowel = false;
            while (!isVowel && i < s.length()) {
                switch (chars[i]) {
                    case 'a':
                    case 'i':
                    case 'e':
                    case 'u':
                    case 'o':
                    case 'A':
                    case 'I':
                    case 'E':
                    case 'U':
                    case 'O':
                        isVowel = true;
                        break;
                    default:
                        i++;
                }
            }
            isVowel = false;
            while (!isVowel && j >= 0) {
                switch (chars[j]) {
                    case 'a':
                    case 'i':
                    case 'e':
                    case 'u':
                    case 'o':
                    case 'A':
                    case 'I':
                    case 'E':
                    case 'U':
                    case 'O':
                        isVowel = true;
                        break;
                    default:
                        j--;
                }
            }

            if (i >= j) {
                break;
            }
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;

            i++;
            j--;

        }

        return new String(chars);

    }

    public static void main(String[] args) {
        String s = ".,";
        System.out.println(reverseVowels(s));
    }
}
