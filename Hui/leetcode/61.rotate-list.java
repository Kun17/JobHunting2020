/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int n = 0;
        ListNode dummy = new ListNode(0, head);
        ListNode last = dummy;
        while (dummy.next != null) {
            n++;
            last = last.next;
            dummy.next = dummy.next.next;
        }
        
        last.next = head;
        k %= n;

        dummy.next = head;
        ListNode prev = dummy;
        while (n - k > 0) {
            k++;
            prev = prev.next;
            dummy.next = dummy.next.next;
        }

        prev.next = null;

        return dummy.next;
    }
}
// @lc code=end

