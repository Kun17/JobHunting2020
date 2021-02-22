/*
 * @lc app=leetcode id=1537 lang=java
 *
 * [1537] Get the Maximum Score
 */

// @lc code=start
class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int MOD = 1000000007;
        int i = 0, j = 0;

        // long sum1 = nums1[0], sum2 = nums2[0];
        // long ret = 0;
        // while (i < n && j < m) {
        //     if (nums1[i] == nums2[j]) {
        //         ret = (ret + Math.max(sum1, sum2)) % MOD;
        //         i++;
        //         j++;
        //         sum1 = i < n? nums1[i]: 0;
        //         sum2 = j < m? nums2[j]: 0;
        //     } else if (nums1[i] < nums2[j]) {
        //         i++;
        //         if (i < n) {
        //             sum1 = sum1 + nums1[i];
        //         }
        //     } else {
        //         j++;
        //         if (j < m) {
        //             sum2 = sum2 + nums2[j];
        //         }
        //     }
        // }
        
        long sum1 = 0, sum2 = 0;
        long ret = 0;
        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                ret = (ret + Math.max(sum1, sum2) + nums2[j]) % MOD;
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                sum1 = sum1 + nums1[i];
                i++;
            } else {
                sum2 = sum2 + nums2[j];
                j++;
            }
        }

        // i++;
        while (i < n) {
            sum1 = sum1 + nums1[i++];
        }

        // j++;
        while (j < m) {
            sum2 = sum2 + nums2[j++];
        }
        // System.out.println(sum1 + " " + sum2);
        ret = (ret + Math.max(sum1, sum2)) % MOD;
        return (int) ret;
    }
    
    /*
    public int maxSum(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return maxSum(nums2, nums1);
        }
        int n = nums1.length, m = nums2.length;
        int MOD = 1000000007;
        long[] sum1 = new long[n + 1];
        long[] sum2 = new long[m + 1];
        for (int i = 0; i < n; i++) {
            sum1[i + 1] = sum1[i] + (long) nums1[i];
        }
        for (int i = 0; i < m; i++) {
            sum2[i + 1] = sum2[i] + (long) nums2[i];
        }

        int prev1 = -1, prev2 = -1;
        long ret = 0;
        for (int i = 0; i < n; i++) {
            int target = nums1[i];
            int index = find(nums2, target);
            if (index != -1) {
                // System.out.println(nums1[i] + " " + nums2[index]);
                // int sum1 = 0;
                // for (int j = prev1 + 1; j <= i; j++) {
                //     sum1 += nums1[j];
                //     sum1 %= MOD;
                // }
                // int sum2 = 0;
                // for (int j = prev2 + 1; j <= index; j++) {
                //     sum2 += nums2[j];
                //     sum2 %= MOD;
                // }
                ret += Math.max(sum1[i + 1] - sum1[prev1 + 1], sum2[index + 1] - sum2[prev2 + 1]);
                // ret += Math.max(sum1, sum2);
                ret %= MOD;
                // ret -= target;
                prev1 = i;
                prev2 = index;
                // System.out.println(ret + " --");
                
            }
        }

        ret += Math.max(sum1[n] - sum1[prev1 + 1], sum2[m] - sum2[prev2 + 1]);
        return (int) (ret % MOD);
    }

    public int find(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (e - s > 1) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                s = mid;
            } else {
                e = mid;
            }
        }

        if (nums[s] == target) return s;
        if (nums[e] == target) return e;

        return -1;
    }
    */
}
// @lc code=end

