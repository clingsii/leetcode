package com.lc.leetcode;

/**
 * Created by caoling on 2016/11/7.
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class T6 {

    public static String convert(String s, int numRows) {

        StringBuilder[] result = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            result[i] = new StringBuilder();
        }

        if (numRows == 1) {
            return s;
        } else if (numRows == 2) {
            boolean even = true;
            for (int i = 0; i < s.length(); i++) {
                if (even) {
                    result[0].append(s.charAt(i));
                    even = false;
                } else {
                    result[1].append(s.charAt(i));
                    even = true;
                }
            }
        } else {


            int row = 0;
            int col = 0;


            for (char c : s.toCharArray()) {
                result[row].append(c);

                if (col % 2 == 0) {
                    if (row < numRows - 1) {
                        row++;
                    } else {
                        row = numRows - 2;
                        col++;
                    }
                } else {
                    if (row >= 2) {
                        row--;
                    } else {
                        row = 0;
                        col++;
                    }
                }

            }
        }

        for (int i = 1; i < numRows; i++) {
            result[0].append(result[i]);
        }


        return result[0].toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("ABC", 2));
    }
}
