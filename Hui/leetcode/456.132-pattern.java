/*
 * @lc app=leetcode id=456 lang=java
 *
 * [456] 132 Pattern
 */

// @lc code=start
class Solution {
    public boolean find132pattern(int[] nums) {
        int[] leftMins = new int[nums.length];
        leftMins[0] = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++) {
            leftMins[i] = Math.min(leftMins[i - 1], nums[i - 1]);
        }

        Stack<Integer> stk = new Stack<Integer>();
        for(int i = nums.length - 1; i >= 0; i--) {
            while(stk.size() > 0 && nums[stk.peek()] < nums[i]) {
                if(leftMins[i] < nums[stk.pop()]) {
                    return true;
                }
            }
            stk.push(i);
        }
        
        return false;
    }
}
// @lc code=end

