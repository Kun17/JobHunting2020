/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    int[] memo;
    public int numTrees(int n) {
        memo = new int[n];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return construct(1, n);
    }

    public int construct(int s, int e) {
        if (s > e) return 1;
        if (memo[e - s] != -1) return memo[e - s];

        int count = 0;
        for (int i = s; i <= e; i++) {
            int left = construct(s, i - 1);
            int right = construct(i + 1, e);
            count += left * right;
        }

        memo[e - s] = count;
        return memo[e - s];
    }
}
// @lc code=end

