package com.lc.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by caoling on 16/6/5.
 */
public class T349 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<Integer>();
        int[] result = new int[nums1.length > nums2.length ? nums2.length : nums1.length];
        int pos = 0;
        for (int i : nums1) {
            s1.add(i);
        }
        for (int j : nums2) {
            if (s1.contains(j)) {
                result[pos++] = j;
                s1.remove(j);
            }
        }
        return Arrays.copyOfRange(result, 0, pos);

    }
}
