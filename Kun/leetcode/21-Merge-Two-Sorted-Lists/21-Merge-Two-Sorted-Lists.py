import ListNode

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        pre = dummyHead = ListNode(next = l1)
        while l1 or l2:
            if not l2 or l1 and l1.val < l2.val:
                pre.next = l1
                pre = l1
                l1 = l1.next
            else:
                pre.next = l2
                pre  = l2
                l2 = l2.next
        return dummyHead.next
