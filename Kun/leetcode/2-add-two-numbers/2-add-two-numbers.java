class Solution {
    private ListNode constructListNodeByArr(int[] data){
        ListNode dummyHead = new ListNode(), curNode = dummyHead;
        for (int i = 0; i < data.length; i ++){
            curNode.next = new ListNode(data[i]);
            curNode = curNode.next;
        }
        return dummyHead.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // iterate through l1 and l2, to the end of the longest, check for carry
        ListNode l1Cur = l1;
        ListNode l2Cur = l2;
        ListNode dummyHead = new ListNode(), curNode = dummyHead;
        int carry = 0;
        while(l1Cur != null || l2Cur != null) {
            int x = (l1Cur != null) ? l1Cur.val : 0;
            int y = (l2Cur != null) ? l2Cur.val : 0;
            int curVal = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            // Add a dummy head to avoid assigning next head to curHead
            curNode.next = new ListNode(curVal);
            l1Cur = (l1Cur != null) ? l1Cur.next: null;
            l2Cur = (l2Cur != null) ? l2Cur.next: null;
            curNode = curNode.next;
        }
        if (carry != 0) {
            curNode.next = new ListNode(1);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] l1Data = {9,9,9,9,9,9,9};
        int[] l2Data = {9,9,9,9};
        ListNode l1 = s.constructListNodeByArr(l1Data);
        ListNode l2 = s.constructListNodeByArr(l2Data);
        ListNode res = s.addTwoNumbers(l1, l2);


        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();
    }
}