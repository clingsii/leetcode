package com.lc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoling on 2016/11/4.
 */
public class T412 {
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        int numberOf15 = n % 15 == 0 ? n / 15 : n / 15 + 1;

        for (int i = 0; i < numberOf15; i++) {
            int base = i * 15;
            result.add(base + 1 + "");
            result.add(base + 2 + "");
            result.add("Fizz");
            result.add(base + 4 + "");
            result.add("Buzz");
            result.add("Fizz");
            result.add(base + 7 + "");
            result.add(base + 8 + "");
            result.add("Fizz");
            result.add("Buzz");
            result.add(base + 11 + "");
            result.add("Fizz");
            result.add(base + 13 + "");
            result.add(base + 14 + "");
            result.add("FizzBuzz");

        }
        return result.subList(0, n);
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(100));
    }
}
