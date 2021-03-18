/*
 * @lc app=leetcode id=853 lang=java
 *
 * [853] Car Fleet
 */

// @lc code=start
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(cars, (a, b) -> a[0] - b[0]);
        
        double t = 0;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            double cur = 1.0 * (target - cars[i][0]) / cars[i][1];
            if (cur > t) {
                count = count + 1;
                t = cur;
            }
        }

        return count;
    }
}
// @lc code=end

