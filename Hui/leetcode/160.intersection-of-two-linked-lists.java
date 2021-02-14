/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        ListNode head1 = headA;
        while(head1 != null) {
            len1++;
            head1 = head1.next;
        }

        int len2 = 0;
        ListNode head2 = headB;
        while(head2 != null) {
            len2++;
            head2 = head2.next;
        }

        head1 = headA;
        head2 = headB;
        if(len1 < len2) {
            int diff = len2 - len1;
            while(diff > 0) {
                diff--;
                head2 = head2.next;
            }
        } else if(len1 > len2) {
            int diff = len1 - len2;
            while(diff > 0) {
                diff--;
                head1 = head1.next;
            }
        }

        while(head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1;
    }
}
// @lc code=end

