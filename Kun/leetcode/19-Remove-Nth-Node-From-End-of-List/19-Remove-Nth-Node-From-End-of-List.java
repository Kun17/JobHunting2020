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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        int length = 1;
        ListNode nNode = dummyHead;
        while(nNode.next != null && length < n+1){
            nNode = nNode.next;
            length++;
        }
        if(length != n+1) return head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        while(nNode.next != null){
            pre = cur;
            cur = cur.next;
            nNode = nNode.next;
        }
        pre.next = cur.next;
        return dummyHead.next;
    }
}