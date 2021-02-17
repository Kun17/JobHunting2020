/*
 * @lc app=leetcode id=1220 lang=java
 *
 * [1220] Count Vowels Permutation
 */

// @lc code=start
class Solution {
    int[][] dp;
    int[][] adj;
    int mod = 1000000007;
    public int countVowelPermutation(int n) {
        dp = new int[5][n + 1];
        // for (int i = 0; i < 5; i++) {
        //     Arrays.fill(dp[i], 0);
        // }
        adj = new int[5][5];
        adj[0][1] = 1;
        adj[1][0] = 1;
        adj[1][2] = 1;
        for (int i = 0; i < 5; i++) {
            if (i != 2) {
                adj[2][i] = 1;
            }
        }
        adj[3][2] = 1;
        adj[3][4] = 1;
        adj[4][0] = 1;

        return helper(-1, n);
    }

    public int helper(int prev, int n) {
        if (n == 0) return 1;

        if (prev != -1 && dp[prev][n] != 0) {
            return dp[prev][n];
        }        

        int ret = 0;
        for (int i = 0; i < 5; i++) {
            if (prev == -1 || adj[prev][i] == 1) {
                ret += (helper(i, n - 1) % mod);
                ret %= mod;
            }
        }
        if (prev != -1) {
            dp[prev][n] = ret;
        }
        // System.out.println(prev + " " + n + " " + ret);
        return ret;
    }
}
// @lc code=end

