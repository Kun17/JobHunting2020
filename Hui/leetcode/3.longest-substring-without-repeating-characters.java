/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] chs = new boolean[256];
        int i = 0; 
        int ret = 0;
        for(int j = 0; j < s.length(); j++) {
            while(chs[s.charAt(j)]) {
                chs[s.charAt(i++)] = false;
            }
            ret = Math.max(ret, j - i + 1);
            chs[s.charAt(j)] = true;   
        }
        return ret;
    }
}
// @lc code=end

