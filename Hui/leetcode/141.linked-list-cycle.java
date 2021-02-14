/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy, cur = head;
        while(cur != null) {
            if(cur == dummy) {
                return true;
            }
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return false;
    }
}
// @lc code=end

