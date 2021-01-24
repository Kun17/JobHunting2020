/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 1, cur = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(cnt == 0) {
                cnt = 1;
                cur = nums[i];
            } else if(cur == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return cur;
    }
}
// @lc code=end

