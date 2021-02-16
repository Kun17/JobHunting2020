/*
 * @lc app=leetcode id=633 lang=java
 *
 * [633] Sum of Square Numbers
 */

// @lc code=start
class Solution {
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int)Math.sqrt(c);
        while(i <= j) {
            int cur = i * i + j * j;
            if(cur == c) {
                return true;
            } else if(cur < c) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}
// @lc code=end

