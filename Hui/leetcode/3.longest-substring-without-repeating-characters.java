/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int i = 0; 
        int ret = 0;
        for(int j = 0; j < s.length(); j++) {
            while(set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }
            ret = Math.max(ret, j - i + 1);
            set.add(s.charAt(j));
        }
        return ret;
    }
}
// @lc code=end

