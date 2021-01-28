class Solution {
    public ListNode sortList_topDown(ListNode head) {
        // I should have not read the hint!!
        // Try with top-down merge sort/ or just DAC
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList_topDown(head);
        ListNode right = sortList_topDown(mid);
        return merge(left, right);
    }

    private ListNode getMid(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode midPrev = null;
        while (head != null && head.next != null){
            midPrev = (midPrev == null)? head: midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    private ListNode merge(ListNode left, ListNode right){
        ListNode l = left;
        ListNode r = right;
        ListNode dummyHead = new ListNode();
        ListNode curNode = dummyHead;
        while (l != null || r != null){
            if (r == null || (l != null && l.val <= r.val)) {
                curNode.next = l;
                l = l.next;
            } else {
                curNode.next = r;
                r = r.next;
            }
            curNode = curNode.next;
        }
        return dummyHead.next;
    }


    // 不写了，啥东西啊
    public ListNode sortList_bottomUp(ListNode head) {
        // I should have not read the hint!!
        // Try with top-down merge sort/ or just DAC
        if (head == null || head.next == null) {
            return head;
        }
        int length = getSize(head);
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode start = head;
        for(int size = 1; size < length; size *= 2){
            while(start.next != null) {
                ListNode tail = split(start, size);
            }
        }
    }

    ListNode split(ListNode start, int size){

    }

    int getSize(ListNode head){
        int cnt = 0;
        while(head != null){
            cnt++;
            head = head.next;
        }
        return cnt;
    }
    

    public static void main(String[] Args){
        ListNode head = new ListNode(-1);
        ListNode curNode = head;
        int[] nums = new int[]{-1,5,3,4,0};
        for (int i = 1; i < nums.length; i++) {
            curNode.next = new ListNode(nums[i]);
            curNode = curNode.next;
        }
        Solution s = new Solution();
        ListNode newHead = s.sortList_topDown(head);
        while(newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}