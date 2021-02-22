/*
 * @lc app=leetcode id=334 lang=java
 *
 * [334] Increasing Triplet Subsequence
 */

// @lc code=start
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num > num2) {
                return true;
            }

            if (num < num2 && num > min) {
                num2 = num;
            }
            min = Math.min(min, num);
            // System.out.println(min + " " + num2);
        }

        return false;
    }
}
// @lc code=end

