/*
 * @lc app=leetcode id=775 lang=java
 *
 * [775] Global and Local Inversions
 */

// @lc code=start
class Solution {
    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                if (A[i] != i + 1 || A[i + 1] != i) {
                    return false;
                }
            }
        }

        return true;
    }
}
// @lc code=end

