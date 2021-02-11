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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        int mid = (0 + lists.length)/2;
        ListNode[] lList = new ListNode[mid];
        ListNode[] rList = new ListNode[lists.length - mid];
        for(int i = 0; i < mid; i++){
            lList[i] = lists[i];
        }
        for(int i = mid; i < lists.length; i++){
            rList[i-mid] = lists[i];
        }
        ListNode l = mergeKLists(lList);
        ListNode r = mergeKLists(rList);
        ListNode res =  merge(l, r);
        return res;
    }

    private ListNode merge(ListNode l, ListNode r){
        if(l == null) return r;
        if(r == null) return l;

        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;

        while(l != null || r != null){
            if(r == null || l != null && l.val < r.val) {
                cur.next = l;
                l = l.next;
                cur = cur.next;
            }
            if(l == null && r == null) break;
            if(l == null || r != null && r.val <= l.val){
                cur.next = r;
                r = r.next;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] Args){

    }
}