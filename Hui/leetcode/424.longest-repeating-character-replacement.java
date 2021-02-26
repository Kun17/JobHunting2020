/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0, end = 0;
        int maxCount = 0;
        int[] chs = new int[26];
        int maxLen = 0;
        while (end < s.length()) {
            maxCount = Math.max(maxCount, ++chs[s.charAt(end) - 'A']);
            if (end - start - maxCount + 1 > k) {
                chs[s.charAt(start) - 'A']--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
            
        }
        
        return maxLen;
    }
}
// @lc code=end

