/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<Integer>();
        int[] ret = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            while(stk.size() > 0 && nums[stk.peek()] < nums[i]) {
                ret[stk.peek()] = nums[i];
                stk.pop();
            }
            stk.push(i);
        }

        for(int i = 0; i < nums.length; i++) {
            while(nums[stk.peek()] < nums[i]) {
                ret[stk.peek()] = nums[i];
                stk.pop();
            }
        }

        while(stk.size() > 0) {
            ret[stk.pop()] = -1;
        }

        return ret;
    }
}
// @lc code=end

