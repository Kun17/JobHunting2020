package main

import (
	"fmt"
	"strings"
)

func lengthOfLongestSubstring(s string) int {
	// We need to calculate the substring with non-repeating characters
	// Starting from [0, 0) to [0, j), namely substring ij, when j is already in ij
	// we increate i to the pos of last charAt(j) + 1
	// Then continue increase j
	// We can do this using map
	// Store char and pos in map, when last pos of char j is bigger than i, we update i
	// get the max j - i + 1 to the ans
	valPosMap := make(map[rune]int)
	i := 0
	ans := 0
	for j, c := range s {
		if existPos := valPosMap[c]; existPos != 0 || strings.Index(s, string(c)) == 0 {
			i = existPos + 1
		}
		if j-i+1 > ans {
			ans = j - i + 1
		}
		valPosMap[c] = j
	}
	return ans
}

func main() {
	fmt.Println(strings.Index("abcabcbb", "a"))
	fmt.Println(lengthOfLongestSubstring("abcabcbb"))
}
