/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        /*
        char[] c = new char[2 * s.length() + 3];
        c[0] = '$'; 
        c[c.length - 1] = '^';
        for(int i = 1; i < c.length - 1; i++) {
            if ((i - 2) % 2 == 0) {
                c[i] = s.charAt((i - 2) / 2);
            } else {
                c[i] = '#';
            }
        }

        int retIndex = -1, maxLen = -1;
        int curMaxIndex = 0, curMaxLen = 0;

        int[] dp = new int[c.length - 1];
        for(int i = 1; i < c.length - 1; i++) {
            if (i < curMaxIndex) {
                dp[i] = Math.min(dp[2 * curMaxIndex - i], curMaxLen - i);
            }
            while(c[i - dp[i] - 1] == c[i + dp[i] + 1]) {
                dp[i]++;
            }
            if(i + dp[i] > curMaxLen) {
                curMaxIndex = i;
                curMaxLen = i + dp[i];
            }
            if(dp[i] > maxLen) {
                retIndex = i;
                maxLen = dp[i];
            }
        }

        return s.substring((retIndex - maxLen) / 2, (retIndex - maxLen) / 2 + maxLen);
        */

        
        // O(N^2) Solution
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

