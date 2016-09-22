package com.lc.leetcode;

/**
 * Created by Ling Cao on 2016/9/22.
 */
public class T371 {
    public static int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        if (a > 0 && b > 0) {
            return getSumOp(a, b);
        }
        if (a > 0 && b < 0) {
            if (a == b * (-1)) {
                return 0;
            }
            if (a > b * (-1)) {
                return getSubOp(a, b * (-1));
            } else {
                return getSubOp(b * (-1), a) * (-1);
            }
        }
        if (a < 0 && b > 0) {
            if (a == b * (-1)) {
                return 0;
            }
            if (b > a * (-1)) {
                return getSubOp(b, a * (-1));
            } else {
                return getSubOp(a * (-1), b) * (-1);
            }
        }
        return getSum(a * (-1), b * (-1)) * (-1);
    }

    private static int getSubOp(int a, int b) {
        if (b == 0) {
            return a;
        } else if (b == 1) {
            if (a % 2 == 1) {
                return a ^ 1;
            } else {
                return getSumOp(2 * getSubOp(a / 2, 1), 1);
            }
        } else {
            int r1 = a % 2;
            int r2 = b % 2;
            if (r1 == 0 && r2 == 0) {
                return 2 * getSubOp(a / 2, b / 2);
            } else if (r1 == 1 && r2 == 0) {
                return getSubOp(2 * getSubOp(a / 2, b / 2), 1);
            } else {
                return getSubOp(2 * getSubOp(a / 2, b / 2), 1);
            }
        }
    }

    private static int getSumOp(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (b == 1) {
            if (a % 2 == 0) {
                return a | 1;
            } else {
                return 2 * getSumOp(a / 2, 1);
            }
        }
        if (a == 1) {
            if (b % 2 == 0) {
                return b | 1;
            } else {
                return 2 * getSumOp(b / 2, 1);
            }
        }

        int r1 = a % 2;
        int r2 = b % 2;

        if (r1 == 0 && r2 == 0) {
            return 2 * getSumOp(a / 2, b / 2);
        }
        if (r1 == 1 && r2 == 1) {
            return 2 * getSumOp(getSumOp(a / 2, b / 2), 1);
        }
        if ((r1 == 0 && r2 == 1) || (r1 == 1 && r2 == 0)) {
            return getSumOp(2 * getSumOp(a / 2, b / 2), 1);
        }

        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(1 | 2);
//
        System.out.println(getSum(2147483647, -2147483648));
    }
}
