/*
 * @lc app=leetcode id=1358 lang=java
 *
 * [1358] Number of Substrings Containing All Three Characters
 */

// @lc code=start
class Solution {
    public int numberOfSubstrings(String s) {
        int[] cnt = new int[3];
        int l = 0, r = 0;
        int ret = 0;
        while(r < s.length()) {
            cnt[s.charAt(r) - 'a']++;
            while(cnt[0] != 0 && cnt[1] != 0 && cnt[2] != 0) {
                ret += s.length() - r;
                cnt[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return ret;
    }
}
// @lc code=end

