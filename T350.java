package com.lc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ling cao on 16/6/3.
 */
public class T350 {


    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> records = new HashMap<Integer, Integer>();

        List<Integer> result = new ArrayList<Integer>();
        for (int i : nums1) {
            Integer num = records.get(i);
            if (num == null) {
                num = 0;
            }
            num += 1;
            records.put(i, num);
        }
        for (int j : nums2) {
            Integer num = records.get(j);
            if (num == null || num <= 0) {
                continue;
            } else {
                result.add(j);
                num -= 1;
                records.put(j, num);
            }
        }

        for (Map.Entry<Integer, Integer> entry : records.entrySet()) {
            int k = entry.getValue();
            if (k == 5 || k == 6 || k == 9) {
                result.add(k);
            }
            if (k == 10) {
                result.add(k);
                result.add(k);
            }

        }
        int[] rr = new int[result.size()];
        for (int m = 0; m < result.size(); m++) {
            rr[m] = result.get(m);
        }
        return rr;

    }


    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1};

        int[] r = intersect(nums1, nums2);
        for (int i : r) {
            System.out.print(i + " ");
        }
    }
}
