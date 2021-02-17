/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int p = 0, n = 0;
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            if (num > 0) {
                p = Math.max(p * num, num);
                n = n * num;
            } else if (num < 0) {
                int prevp = p;
                p = n * num;
                n = Math.min(prevp * num, num);
            } else {
                p = 0;
                n = 0;
                max = Math.max(max, 0);
            }
            // System.out.println(num + " " + p + " " + n);
            if (p != 0) {
                max = Math.max(max, p);
            }
            if (n != 0) {
                max = Math.max(max, n);
            }
        }
        return max;
    }
    // [-4,-3,-2]
}
// @lc code=end

