/*
 * @lc app=leetcode id=1465 lang=java
 *
 * [1465] Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 */

// @lc code=start
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int m = horizontalCuts.length;
        int n = verticalCuts.length;
        long MOD = 1000000007;

        long max1 = 0;
        for (int i = 0; i <= m; i++) {
            if (i == 0) {
                max1 = horizontalCuts[0];
            } else if (i == m) {
                max1 = Math.max(max1, h - horizontalCuts[m - 1]);
            } else {
                max1 = Math.max(max1, horizontalCuts[i] - horizontalCuts[i - 1]);
            }
        }

        long max2 = 0;
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                max2 = verticalCuts[0];
            } else if (i == n) {
                max2 = Math.max(max2, w - verticalCuts[n - 1]);
            } else {
                max2 = Math.max(max2, verticalCuts[i] - verticalCuts[i - 1]);
            }
        }

        return (int) (max1 * max2 % MOD);

        // int max = 0;
        // for (int i = 0; i <= m; i++) {
        //     for (int j = 0; j <= n; j++) {
        //         int l1 = h;
        //         if (i < m) {
        //             l1 = horizontalCuts[i];
        //         }
        //         if (i > 0) {
        //             l1 = l1 - horizontalCuts[i - 1];
        //         }
        //         int l2 = w;
        //         if (j < n) {
        //             l2 = verticalCuts[j];
        //         }
        //         if (j > 0) {
        //             l2 = l2 - verticalCuts[j - 1];
        //         }
        //         max = Math.max(max, (l1 * l2) % MOD);
        //     }
        // }

        // return max;
    }
}
// @lc code=end

