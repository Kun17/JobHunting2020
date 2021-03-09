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
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead =  new ListNode();
        dummyHead.next = head;
        ListNode cur = head, pre = dummyHead;
        Deque<ListNode> stack = new ArrayDeque<>();
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
            if(stack.size() == k){
                while(!stack.isEmpty()){
                    pre.next = stack.pop();
                    pre = pre.next;
                }
            }
        }
        while(!stack.isEmpty()){
            pre.next = stack.pollLast();
            pre = pre.next;
        }
        pre.next = null;
        return dummyHead.next;        
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummyHead =  new ListNode();
        dummyHead.next = head;
        ListNode cur = head, pre = dummyHead;
        while(cur != null){
            ListNode curK = cur;
            for(int i = 1; i < k && curK != null; i++){
                curK = curK.next;
            }
            if(curK == null) break;
            ListNode revLast = cur;
            ListNode revFirst = null;
            for(int i = 0; i < k; i++){
                ListNode temp = cur.next;
                cur.next = revFirst;
                revFirst = cur;
                cur = temp;
            }
            pre.next = revFirst;
            revLast.next = cur;
            pre = revLast;
        }
        return dummyHead.next;  
    }

    public ListNode reverseKGroup_recursive(ListNode head, int k) {
        ListNode cur = head;
        while(cur != null){
            int count = 0;
            for(int i = 0; i < k && cur != null; i++){
                cur = cur.next;
                count++;
            }
            if(count == k){
                ListNode reverseHead = reverseLinkedList(head, k);
                head.next = this.reverseKGroup_recursive(cur, k);
                return reverseHead;
            }
        }
        return head;  
    }

    private ListNode reverseLinkedList(ListNode head, int k){
        ListNode reverseHead = null;
        ListNode cur = head;
        for(int i = 0; i < k; i++){
            ListNode temp = cur.next;
            cur.next = reverseHead;
            reverseHead = cur;
            cur = temp;
        }
        head.next = cur;
        return reverseHead;
    }

    public static void main(String[] Args){
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution s = new Solution();
        ListNode newH = s.reverseKGroup_recursive(head, 3);
        for(int i = 0; i < 5; i++){
            System.out.print(newH.val + " ");
            newH = newH.next;
        }
        System.out.println();
    }
}