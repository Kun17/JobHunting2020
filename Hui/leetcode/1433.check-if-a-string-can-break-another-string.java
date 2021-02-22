/*
 * @lc app=leetcode id=1433 lang=java
 *
 * [1433] Check If a String Can Break Another String
 */

// @lc code=start
class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] nums1 = new int[26];
        int[] nums2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            nums1[s1.charAt(i) - 'a']++;
            nums2[s2.charAt(i) - 'a']++;
        }


        int sign = 0;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            count1 += nums1[i];
            count2 += nums2[i];
            if (count1 > count2) {
                if (sign < 0) return false;
                sign = 1;
            } else if (count1 < count2) {
                if (sign > 0) return false;
                sign = -1;
            }
        }

        return true;
    }
}
// @lc code=end

