/*
 * @lc app=leetcode id=873 lang=java
 *
 * [873] Length of Longest Fibonacci Subsequence
 */

// @lc code=start
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int[][] dp = new int[arr.length][arr.length];
        int ret = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                int target = arr[j] - arr[i];
                if(target >= arr[i] || !map.containsKey(target)) {
                    dp[i][j] = 2;
                } else {
                    int targetIndex = map.get(target);
                    dp[i][j] = dp[targetIndex][i] + 1;
                }
                ret = Math.max(ret, dp[i][j]);
            }
        }
        if(ret == 2) {
            return 0;
        }
        return ret;
    }
}
// @lc code=end

