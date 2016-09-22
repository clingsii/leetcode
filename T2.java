package com.lc.leetcode;

/**
 * Created by ling cao on 16/6/1.
 */
public class T2 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        boolean isFirst = true;
        ListNode last = null;

        boolean isCarry = false;

        while (l1 != null || l2 != null) {
            int v = 0;
            if (isCarry) {
                v += 1;
                isCarry = false;
            }

            if (l1 != null && l2 != null) {
                v += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;

            } else if (l1 == null) {
                v += l2.val;
                l2 = l2.next;

            } else if (l2 == null) {
                v += l1.val;
                l1 = l1.next;
            }
            if (v >= 10) {
                isCarry = true;
                v %= 10;
            }

            ListNode node = new ListNode(v);
            if (isFirst) {
                result = node;
                isFirst = false;
            } else {
                last.next = node;
            }
            last = node;
        }
        if (isCarry) {
            ListNode node = new ListNode(1);
            last.next = node;
        }

        return result;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);
        l1.next = l11;
        l11.next = l12;


        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;

        ListNode r = addTwoNumbers(l1, l2);

        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }

    }
}
