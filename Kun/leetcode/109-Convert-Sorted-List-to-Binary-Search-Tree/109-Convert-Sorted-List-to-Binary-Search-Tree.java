

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Looks like a merge sort~~~
        // Or we can do it with recursion
        return buildTree(head);
    }

    TreeNode buildTree(ListNode head){
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode mid = getMid(head);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(head);
        root.right = buildTree(mid.next);
        return root;
    }

    ListNode getMid(ListNode head){
        ListNode mid = head;
        ListNode preMid = mid;
        while(head != null && head.next != null && head.next.next != null){
            head = head.next.next;
            preMid = mid;
            mid = mid.next;
        }
        if (head != null && head.next != null && head.next.next == null){
            preMid = mid;
            mid = mid.next;
        }
        if (preMid != mid) preMid.next = null;
        return mid;
    }

    ListNode constructLinkedList(int[] vals){
        if (vals.length == 0) return null;
        ListNode first = new ListNode(vals[0]);
        ListNode curNode = first;
        for(int i = 1; i < vals.length; i++){
            curNode.next = new ListNode(vals[i]);
            curNode = curNode.next;
        }
        return first;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[] vals = new int[]{-10, -3, 0, 5, 9};
        ListNode first = s.constructLinkedList(vals);
        TreeNode root = s.sortedListToBST(first);
        System.out.println(root.val);
    }
}