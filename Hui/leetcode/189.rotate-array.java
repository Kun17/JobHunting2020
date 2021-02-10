/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;

        int step = gcd(nums.length, k);
        for (int i = 0; i < step; i++) {
            int temp = nums[i];
            int next = (i + k) % nums.length;
            while (next != i) {
                int t = temp;
                temp = nums[next];
                nums[next] = t;
                next = (next + k) % nums.length;
            }
            nums[i] = temp;
        }
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
}
// @lc code=end

