/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] l = nums1, s = nums2;
        if(nums1.length < nums2.length) {
            l = nums2;
            s = nums1;
        }

        int start = len / 2 - s.length - 1;
        int end = len / 2;
        int i = -1, j = -1;
        while(end >= start) {
            i = start + (end - start) / 2;
            j = len / 2 - 2 - i;
            int sRight = Integer.MAX_VALUE;
            int sLeft = Integer.MIN_VALUE;
            if(j >= 0 && j <= s.length - 1) {
                sLeft = s[j];
            }
            if(j + 1 >= 0 && j + 1 <= s.length - 1) {
                sRight = s[j+1];
            }
            if(i >= 0 && l[i] > sRight) {
                end = i - 1;
            } else if(i + 1 < l.length && l[i+1] < sLeft) {
                start = i + 1;
            } else {
                break;
            }
        }

        int lLeft = Integer.MIN_VALUE;
        if(i >= 0 && i < l.length) {
            lLeft = l[i];
        }
        int lRight = Integer.MAX_VALUE;
        if(i + 1 >= 0 && i + 1 < l.length) {
            lRight = l[i + 1];
        }
        int sLeft = Integer.MIN_VALUE;
        if(j >= 0 && j < s.length) {
            sLeft = s[j];
        }
        int sRight = Integer.MAX_VALUE;
        if(j + 1 >= 0 && j + 1 < s.length) {
            sRight = s[j + 1];
        }

        if(len % 2 == 0) {
            return ((double) Math.max(lLeft, sLeft) + (double) Math.min(lRight, sRight)) / 2.0;
        }
        
        return (double) Math.min(lRight, sRight);
    }
}
// @lc code=end

