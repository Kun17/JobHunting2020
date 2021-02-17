/*
 * @lc app=leetcode id=168 lang=java
 *
 * [168] Excel Sheet Column Title
 */

// @lc code=start
class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        char[] map = new char[26];
        for (int i = 1; i < 26; i++) {
            map[i] = (char) ('A' + i - 1);
            // System.out.println(map[i]);
        }
        map[0] = 'Z';
        while (n > 0) {
            int digit = n % 26;
            sb.append(map[digit]);
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

