/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode nextCur = cur.next.next;
            prev.next = cur.next;
            cur.next.next = cur;
            cur.next = nextCur;
            prev = cur;
            cur = nextCur;
        }

        return dummy.next;
    }
}
// @lc code=end

