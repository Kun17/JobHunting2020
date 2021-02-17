/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        ListNode cur = head;
        dummy.next = cur;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            if (prev.next == cur) {
                prev = prev.next;
            } else {
                prev.next = cur.next;
            }

            cur = cur.next;
        }

        return dummy.next;
    }
}
// @lc code=end

