/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 */

// @lc code=start
class Solution {
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }

        return mergeAndSort(nums, 0, nums.length - 1, temp);
    }

    public int mergeAndSort(int[] nums, int si, int ei, int[] temp) {
        if (si >= ei) {
            return 0;
        }

        int mid = si + (ei - si) / 2;
        int left = mergeAndSort(nums, si, mid, temp);
        int right = mergeAndSort(nums, mid + 1, ei, temp);

        int count = merge(nums, si, ei, temp);

        // System.out.println("si=" + si + " ei=" + ei + " count=" + (left + right + count));
        // for (int i = si; i <= ei; i++) {
        //     System.out.print(nums[i] + " ");
        // }
        // System.out.println();
        return left + right + count;
    }

    public int merge(int[] nums, int si, int ei, int[] temp) {
        for (int i = si; i <= ei; i++) {
            temp[i] = nums[i];
        }

        int mid = si + (ei - si) / 2;
        int i = si, j = mid + 1;
        int count = 0;
        while (i <= mid) {
            while (j <= ei && (long) temp[i] > 2 * (long) temp[j]) {
                j++;
            }
            // System.out.println()
            count += j - mid - 1;
            i++;
        }

        i = si;
        j = mid + 1;
        for (int k = si; k <= ei; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == ei + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] < temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
        }
        return count;
    }
}
// @lc code=end

