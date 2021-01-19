package main

import "fmt"

type linkedList struct {
	head *node
	tail *node
}

type node struct {
	next *node
	data interface{}
}

func newLinkedList() *linkedList {
	return &linkedList{}
}

func (l *linkedList) add(d interface{}) {
	newNode := node{
		data: d,
	}
	if l.head == nil {
		l.head = &newNode
		l.tail = &newNode
		return
	}
	if l.head == l.tail {
		l.head.next = &newNode
		l.tail = &newNode
		return
	}
	l.tail.next = &newNode
	l.tail = &newNode
}

type hashTable struct {
	length int
	table  []*linkedList
}

type hashData struct {
	key   int
	value int
}

func newHashTable(length int) *hashTable {
	newTable := make([]*linkedList, length)
	for i := range newTable {
		newTable[i] = newLinkedList()
	}
	return &hashTable{
		length: length,
		table:  newTable,
	}
}

func calHash(val int) int {
	return ((val * val) * 2654435761) % (2 ^ 32)
}

func index(hashNum int, length int) int {
	return hashNum % length
}

func (h *hashTable) add(key int, val int) error {
	i := index(calHash(key), h.length)
	for curNode := h.table[i].head; curNode != nil; curNode = curNode.next {
		res, ok := curNode.data.(hashData)
		if ok {
			if res.value == val {
				return nil
			}
		} else {
			return fmt.Errorf("Type assertion failed in hash add")
		}
	}
	h.table[i].add(hashData{
		key:   key,
		value: val,
	})
	return nil
}

func (h *hashTable) get(key int, val int) (int, error) {
	i := index(calHash(key), h.length)
	for curNode := h.table[i].head; curNode != nil; curNode = curNode.next {
		res, ok := curNode.data.(hashData)
		if ok {
			if calHash(res.key) == calHash(key) && val != res.value {
				return res.value, nil
			}
		} else {
			return 0, fmt.Errorf("Type assertion failed in hash add")
		}
	}
	return 0, fmt.Errorf("No data found")
}

func twoSum(nums []int, target int) []int {
	var res []int
	numHashTable := newHashTable(len(nums))
	for i, num := range nums {
		err := numHashTable.add(num, i)
		if err != nil {
			fmt.Println(err.Error())
		}
	}
	for i, num := range nums {
		compliment := target - num
		compIndex, err := numHashTable.get(compliment, i)
		if compIndex == i || nums[compIndex] != compliment {
			continue
		}
		if err == nil {
			return append(res, i, compIndex)
		}
	}
	return res
}

func main() {
	nums := []int{5, 75, 25}
	target := 100
	fmt.Println(twoSum(nums, target))
}
