/*
 * @lc app=leetcode id=1423 lang=java
 *
 * [1423] Maximum Points You Can Obtain from Cards
 */

// @lc code=start
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int start = n - k, end = n - 1;
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += cardPoints[i];
        }

        int max = sum;
        end++;
        while (end < n + k) {
            int idx = end % n;
            sum = sum + cardPoints[idx] - cardPoints[start++];
            max = Math.max(max, sum);
            end++;
        }

        return max;
    }
}
// @lc code=end

