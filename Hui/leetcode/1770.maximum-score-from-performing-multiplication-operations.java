class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int[][] memo = new int[n][multipliers.length];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return helper(nums, multipliers, 0, n - 1, 0, memo);
    }
    
    public int helper(int[] nums, int[] m, int s, int e, int mi, int[][] memo) {
        if (mi == m.length) return 0;
        if (memo[s][mi] != -1) return memo[s][mi];
        
        int max = Integer.MIN_VALUE;
        max = Math.max(max, nums[s] * m[mi] + helper(nums, m, s + 1, e, mi + 1, memo));
        if (s != e) {
            max = Math.max(max, nums[e] * m[mi] + helper(nums, m, s, e - 1, mi + 1, memo));
        }
        
        memo[s][mi] = max;
        return memo[s][mi];
    }
}
