/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int si, int ei) {
        if(si == ei) {
            return lists[si];
        }

        int mid = si + (ei - si) / 2;
        ListNode l1 = mergeKLists(lists, si, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, ei);

        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }
        while(l1 != null) {
            prev.next = l1;
            l1 = l1.next;
            prev = prev.next;
        }
        while(l2 != null) {
            prev.next = l2;
            l2 = l2.next;
            prev = prev.next;
        }

        return dummy.next;
    }

/*
    Approach 1: Heap
    Time: O(nlogk)
    Space: O(k)

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(
            new Comparator<ListNode>() {
                public int compare(ListNode a, ListNode b) {
                    return a.val - b.val;
                }
            }
        );

        for(ListNode node: lists) {
            if(node != null) {
                heap.add(node);
            }
        }

        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while(heap.size() > 0) {
            ListNode cur = heap.poll();
            prev.next = cur;
            if(cur.next != null) {
                heap.add(cur.next);
            }
            prev = cur;
        }

        return dummy.next;
    }
*/
}
// @lc code=end

