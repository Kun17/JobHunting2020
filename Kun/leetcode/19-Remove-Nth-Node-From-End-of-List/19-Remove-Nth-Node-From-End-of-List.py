# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import ListNode

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        dummyHead = ListNode(next = head)
        fast = slow = dummyHead
        for _ in range(n-1):
            fast = fast.next
        if not fast:
            return dummyHead.next
        pre = dummyHead
        while fast.next:
            pre = slow
            slow = slow.next
            fast = fast.next
        pre.next = slow.next
        return dummyHead.next

