/*
 * @lc app=leetcode id=1130 lang=java
 *
 * [1130] Minimum Cost Tree From Leaf Values
 */

// @lc code=start
class Solution {
    public int mctFromLeafValues(int[] arr) {
        // long[] {min sum, max leaf}
        long[][][] memo = new long[arr.length][arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            memo[i][i][1] = arr[i];
        }

        helper(arr, 0, arr.length - 1, memo);
        return (int) memo[0][arr.length - 1][0];
    }

    public long[] helper(int[] nums, int s, int e, long[][][] memo) {
        if (memo[s][e][1] != 0) return memo[s][e];

        long min = Long.MAX_VALUE;
        long maxLeaf = Long.MIN_VALUE;
        for (int i = s; i < e; i++) {
            long v1[] = helper(nums, s, i, memo);
            long v2[] = helper(nums, i + 1, e, memo);
            if (v1[0] + v2[0] + v1[1] * v2[1] < min) {
                min = v1[0] + v2[0] + v1[1] * v2[1];
                maxLeaf = Math.max(maxLeaf, v1[1]);
                maxLeaf = Math.max(maxLeaf, v2[1]);
                
            }
        }
        // System.out.println(s + " " + e +  " " + min + " " + multiple);
        memo[s][e][0] = min;
        memo[s][e][1] = maxLeaf;
        return memo[s][e];
    }
}
// @lc code=end

