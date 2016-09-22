package com.lc.leetcode;

/**
 * Created by caoling on 16/6/4.
 */
public class T283 {
    public static void moveZeroes(int[] nums) {
        int head = 0;
        int tail = 0;
        while (tail < nums.length && head < nums.length) {
            while (nums[head] != 0) {
                head++;
                if (head > nums.length - 1) {
                    break;
                }
            }
            while (nums[tail] == 0) {
                tail++;
                if (tail > nums.length - 1) {
                    break;
                }

            }
            if (head > tail) {
                tail++;
                continue;
            }
            if (tail > nums.length - 1 || head > nums.length - 1) {
                break;
            }
            nums[head] = nums[tail];
            nums[tail] = 0;
            head++;
            tail++;
            if (head > nums.length - 1 || tail > nums.length - 1) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1};
        moveZeroes(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
