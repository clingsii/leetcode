package com.lc.leetcode;

/**
 * Created by caoling on 16/6/4.
 */
public class T169 {

    public static int majorityElement(int[] nums) {
        if (nums.length == 1 || nums.length == 2) {
            return nums[0];
        }
        int[] pos = new int[nums.length/2];
        int[] value = new int[nums.length/2];

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(majorityElement(nums));
    }


}
