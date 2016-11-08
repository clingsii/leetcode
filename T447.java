package com.lc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caoling on 2016/11/8.
 */
public class T447 {

    public static int numberOfBoomerangs(int[][] points) {
        long[][] sDistance = new long[points.length][points.length];

        int result = 0;

        Map<Long, Integer> distanceMap;

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = 0; j < points.length; j++) {

                if (sDistance[i][j] == 0) {//suppose no identical point
                    long sd = sDistance(points[i][0], points[i][1],
                            points[j][0], points[j][1]);
                    sDistance[i][j] = sd;
                    sDistance[j][i] = sd;
                }
            }

            sDistance[i][i] = -1;

            distanceMap = new HashMap<>();
            for (long d : sDistance[i]) {
                Integer v = distanceMap.get(d);
                if (v == null) {
                    v = 0;
                }
                v++;
                distanceMap.put(d, v);
            }


            for (int v : distanceMap.values()) {
                if (v >= 2) {
                    result += v * (v - 1); // (the order of the tuple matters)
                    // so it's 2*C(2,N)
                }
            }
        }


        distanceMap = new HashMap<>();

        //the last row
        for (long d : sDistance[points.length - 1]) {
            Integer v = distanceMap.get(d);
            if (v == null) {
                v = 0;
            }
            v++;
            distanceMap.put(d, v);
        }


        for (int v : distanceMap.values()) {
            if (v >= 2) {
                result += v * (v - 1);
            }
        }

        return result;
    }

    private static long sDistance(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        System.out.println(numberOfBoomerangs(points));
    }
}
