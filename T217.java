package com.lc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by caoling on 16/6/7.
 */
public class T217 {




    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return false;
        }
        if (nums.length == 2) {
            return nums[0] == nums[1];
        }
        Set<Integer> set = new HashSet<Integer>(nums.length * 2);
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }
}
