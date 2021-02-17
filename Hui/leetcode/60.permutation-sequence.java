/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        String s = "";
        int[] used = new int[n + 1];
        int total = 1;
        for (int i = 2; i < n; i++) {
            total *= i;
        }

        for (int num = n; num >= 1; num--) {
            int cur = (k - 1) / total;
            int digit = -1;
            int count = -1;
            for (int i = 1; i <= n; i++) {
                if (used[i] == 0) {
                    digit = i;
                    count++;
                }
                if (cur == count) break;
            }
            // System.out.println("num=" + k + " " + cur + " " + count);
            s = s + digit;
            used[digit] = -1;
            k = k - total * cur;
            if (num > 1) {
                total /= (num - 1);
            }
        }

        // for (int i = 1; i <= n; i++) {
        //     if (nums[i] != -1) {
        //         s = s + i;
        //     }
        // }

        return s;
    }
}
// @lc code=end

