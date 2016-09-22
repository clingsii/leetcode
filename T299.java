package com.lc.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by ling cao on 16/6/3.
 */
public class T299 {

    public static String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;



        int[] nonPosMap = new int[128];

        char[] secretChars = secret.toCharArray();
        char[] guessChars = guess.toCharArray();



        for (int i = 0; i < secretChars.length; i++) {
            int ascii = (int) secretChars[i];
            if (guessChars[i] == secretChars[i]){
                a++;
            }
            nonPosMap[ascii]++;
        }


        for (int i = 0; i < guessChars.length; i++) {
            int ascii = (int) guessChars[i];

            int cnt = nonPosMap[ascii];

            if (cnt <= 0) {
                continue;
            }
            b++;
            nonPosMap[ascii]--;
        }
        b -= a;
        return a + "A" + b + "B";

    }

    public static void main(String[] args) {
        String s1 = "1807";
        String s2 = "7810";
        System.out.println(getHint(s1, s2));
    }
}
