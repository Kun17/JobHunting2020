package numbers

// ListNode is the simple implementation of linkedList
type ListNode struct {
	Val  int
	Next *ListNode
}

// When writing leetcode, write down ideas 1st
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	l1CurNode := l1
	l2CurNode := l2
	res := &ListNode{}
	resCurNode := res
	var surPlus int
	var preNode *ListNode
	for {
		if resCurNode == nil {
			break
		}
		curVal := 0
		if l1CurNode != nil {
			curVal += l1CurNode.Val
			l1CurNode = l1CurNode.Next
		}
		if l2CurNode != nil {
			curVal += l2CurNode.Val
			l2CurNode = l2CurNode.Next
		}
		if surPlus != 0 || curVal != 0 || l1CurNode != nil || l2CurNode != nil {
			resCurNode.Val = (curVal + surPlus) % 10
			surPlus = int((curVal + surPlus) / 10)
			resCurNode.Next = &ListNode{}
		} else {
			if preNode != nil {
				preNode.Next = nil
			}
		}
		preNode = resCurNode
		resCurNode = resCurNode.Next
	}
	return res
}
