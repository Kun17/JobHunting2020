/*
 * @lc app=leetcode id=1027 lang=java
 *
 * [1027] Longest Arithmetic Subsequence
 */

// @lc code=start
class Solution {
    public int longestArithSeqLength(int[] A) {
        Map<Integer, Integer>[] dp = new Map[A.length];
        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<>();
        }

        int max = 1;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int d = A[i] - A[j];
                int len = 2;
                if (dp[j].containsKey(d)) {
                    len = dp[j].get(d) + 1;
                }

                dp[i].put(d, len);
                max = Math.max(max, len);
            }
        }

        return max;
    }
}
// @lc code=end

