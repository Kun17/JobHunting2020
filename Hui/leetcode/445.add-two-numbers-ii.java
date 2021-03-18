/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        int n = 0;
        while (p1 != null) {
            n++;
            p1 = p1.next;
        }

        ListNode p2 = l2;
        int m = 0;
        while (p2 != null) {
            m++;
            p2 = p2.next;
        }

        if (n > m) {
            p1 = l1;
            p2 = l2;
        } else {
            p1 = l2;
            p2 = l1;
        }

        List<Integer> digits = new ArrayList<>();
        int k = Math.abs(m - n);
        while (k-- > 0) {
            digits.add(p1.val);
            p1 = p1.next;
        }

        k = Math.min(m, n);
        while (k-- > 0) {
            digits.add(p1.val + p2.val);
            p1 = p1.next;
            p2 = p2.next;            
        }

        ListNode dummy = new ListNode();
        int carry = 0;
        for (int i = digits.size() - 1; i >= 0; i--) {
            carry += digits.get(i);
            ListNode cur = new ListNode(carry % 10);
            carry /= 10;
            cur.next = dummy.next;
            dummy.next = cur;
        }

        if (carry == 1) {
            ListNode cur = new ListNode(carry);
            cur.next = dummy.next;
            dummy.next = cur;
        }

        return dummy.next;
    }
}
// @lc code=end

