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
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = head, pre = dummyHead;
        while(cur != null && cur.next != null){
            ListNode nn = cur.next.next;
            ListNode next = cur.next;
            pre.next = next;
            next.next = cur;
            cur.next = nn;
            pre = cur;
            cur = nn;
        }
        return dummyHead.next;
    }
}