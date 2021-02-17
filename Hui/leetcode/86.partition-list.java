/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
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
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode();
        ListNode lessCur = less;
        ListNode greater = new ListNode();
        ListNode greaterCur = greater;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                lessCur.next = cur;
                cur = cur.next;
                lessCur = lessCur.next;
                lessCur.next = null;
            } else {
                greaterCur.next = cur;
                cur = cur.next;
                greaterCur = greaterCur.next;
                greaterCur.next = null;
            }
        }

        lessCur.next = greater.next;
        return less.next;
    }
}
// @lc code=end

