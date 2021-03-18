/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(0, nums.length - 1, temp, nums);
        return nums;
    }

    public void mergeSort(int s, int e, int[] temp, int[] nums) {
        
        if (e <= s) return;
        
        int mid = s + (e - s) / 2;
        mergeSort(s, mid, temp, nums);
        mergeSort(mid + 1, e, temp, nums);
        
        for (int i = s; i <= e; i++) {
            temp[i] = nums[i];
        }

        int l = s, r = mid + 1;
        int cur = s;
        while (cur <= e) {
            if (l == mid + 1) {
                nums[cur++] = temp[r++];
            } else if (r == e + 1) {
                nums[cur++] = temp[l++];
            } else if (temp[l] < temp[r]) {
                nums[cur++] = temp[l++];
            } else {
                nums[cur++] = temp[r++];
            }
        }
    }
}
// @lc code=end

