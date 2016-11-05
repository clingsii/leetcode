package com.lc.leetcode;

import java.util.*;

/**
 * Created by caoling on 2016/11/5.
 */
public class T219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            Integer oldPos = map.get(v);
            if (oldPos != null && i - oldPos <= k) {
                return true;
            } else {
                map.put(v, i);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {-1, -1};
        System.out.println(containsNearbyDuplicate(nums, 1));
    }
}
