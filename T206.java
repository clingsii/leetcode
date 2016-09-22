package com.lc.leetcode;

/**
 * Created by caoling on 16/6/6.
 */
public class T206 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode h = head;
        if ( h != null) {
            ListNode t = head.next;
            h.next = null;
            while (t != null) {
                ListNode n = t.next;
                t.next = h;
                h = t;
                t = n;
            }
        }
        return h;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        ListNode nn = reverseList(n1);
        while (nn != null) {
            System.out.println(nn.val);
            nn = nn.next;
        }
    }

}
