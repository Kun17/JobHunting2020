/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        for (int i = 0; i < m - 1; i++) {
            cur = cur.next;
        }

        ListNode beforeM = cur;
        int count = n - m + 1;
        ListNode prev = beforeM;
        cur = cur.next;
        while (count > 0) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count--;
        }
        beforeM.next.next = cur;
        beforeM.next = prev;

        return dummy.next;
    }
}
// @lc code=end

