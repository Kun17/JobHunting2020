/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        if (nums.length == 0) return ret;

        int a = nums[0], b = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - b == 1) {
                b = nums[i];
                continue;
            }
            
            if (a == b) {
                ret.add("" + a); 
            } else {
                ret.add(a + "->" + b);
            }
            a = nums[i];
            b = nums[i];
        }

        if (a == b) {
            ret.add("" + a); 
        } else {
            ret.add(a + "->" + b);
        }
        return ret;
    }
}
// @lc code=end

