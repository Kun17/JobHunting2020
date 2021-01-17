/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        
        if (s == "") return "";
        boolean[] dp = new boolean[s.length()];
        int start = 0, end = 0;
        for(int i = s.length() - 2; i >= 0; i--) {
            for(int j = s.length() - 1; j > i; j--) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(j <= i + 2) {
                        dp[j] = true;
                    } else {
                        dp[j] = dp[j-1];
                    }
                } else {
                    dp[j] = false;
                }

                if(dp[j] && j - i > end - start) {
                    end = j;
                    start = i;
                }
            }
        }

        return s.substring(start, end + 1);

        /* Another solution
        O(n^2)

        if(s == "" || s == null) {
            return "";
        }
        int mid = 0, maxLen = 0;
        char[] c = new char[s.length() * 2 - 1];
        for(int i = 0; i < s.length(); i++) {
            c[2 * i] = s.charAt(i);
            if(2 * i + 1< c.length) {
                c[2 * i + 1] = '%';
            }
        }
        boolean[] valid = new boolean[c.length];
        for(int l = 0; l <= s.length(); l++) {
            for(int i = 0; i < c.length; i++) {
                if(i - l >= 0 && i + l < c.length && c[i - l] == c[i + l] && (valid[i] || l == 0)) {
                    valid[i] = true;
                    if(l > maxLen) {
                        maxLen = l;
                        mid = i;
                    } else if(l > 0 && c[i] == '%') {
                        mid = i;
                    }
                } else {
                    valid[i] = false;
                }
            }
        }
        // System.out.println(maxLen);
        StringBuffer ret = new StringBuffer();
        for(int i = mid - maxLen; i <= mid + maxLen; i++) {
            if(c[i] != '%') {
                ret.append(c[i]);
            }
        }

        return ret.toString();
        */
    }
}
// @lc code=end

