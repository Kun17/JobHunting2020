/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, k);
    }

    public int helper(int[] nums, int si, int ei, int k) {
        if (si == ei) return nums[si];
        // System.out.println(si + " " + ei);
        int i = si + 1;
        int pivot = nums[si];
        for (int j = si + 1; j <= ei; j++) {
            if (nums[j] > pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, si, i - 1);
        if (k == i - si) {
           return nums[i - 1]; 
        } else if (k < i - si) {
            return helper(nums, si, i - 1, k);
        } else {
            return helper(nums, i, ei, k - (i - si));
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

