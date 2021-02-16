/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int n = height.length;
        int[] leftMax = new int[n];
        leftMax[0] = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }

        int rightMax = Integer.MIN_VALUE;
        int water = 0;
        for(int i = n - 1; i >= 0; i--) {
            int bound = Math.min(leftMax[i], rightMax);
            if(bound > height[i]) {
                water += bound - height[i];
            }
            rightMax = Math.max(rightMax, height[i]);
        }

        return water;
    }
}
// @lc code=end

