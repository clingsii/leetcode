package com.lc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ling cao on 16/6/1.
 */
public class T1 {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> expected = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                Integer indice = expected.get(nums[i]);
                if (indice != null) {
                    result[0] = indice;
                    result[1] = i;
                }
            }
            expected.put(target - nums[i], i);

        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {0, 4, 3, 0};
        int target = 0;

        int[] result = twoSum(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
