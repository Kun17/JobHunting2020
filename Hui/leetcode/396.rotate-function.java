/*
 * @lc app=leetcode id=396 lang=java
 *
 * [396] Rotate Function
 */

// @lc code=start
class Solution {
    public int maxRotateFunction(int[] A) {
        int n = A.length;
        int total = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            total += i * A[i];
            sum += A[i];
        }

        int max = total;
        for (int i = n - 1; i > 0; i--) {
            total += sum;
            total -= n * A[i];
            max = Math.max(max, total);
        }

        return max;
    }
}
// @lc code=end

