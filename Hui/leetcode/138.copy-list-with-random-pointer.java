/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node dummy = new Node(0);
        Node copyprev= dummy;
        Node cur = head;
        while (cur != null) {
            Node copycur = new Node(cur.val);
            copyprev.next = cur;
            
            Node next = cur.next;
            cur.next = copycur;
            cur = next;
            copyprev = copycur;
        }

        Node copycur = dummy.next.next;
        copyprev = dummy;
        cur = head;
        while (cur != null) {
            if (copyprev.next.random != null) {
                copycur.random = copyprev.next.random.next;
            }
            cur = cur.next.next;
            copyprev = copycur;
            if (copycur.next != null) {
                copycur = copycur.next.next;
            }
        }

        copyprev = dummy;
        copycur = dummy.next.next;
        cur = head;
        while (cur != null) {
            Node next = cur.next.next;
            copyprev.next = copycur;
            cur.next = copycur.next;


            cur = next;
            copyprev = copycur;
            if (next != null) {
                copycur = next.next;
            }
        }

        return dummy.next;
    }
}
// @lc code=end

