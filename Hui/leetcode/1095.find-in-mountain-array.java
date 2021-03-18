
/*
 * @lc app=leetcode id=1095 lang=java
 *
 * [1095] Find in Mountain Array
 */

// @lc code=start
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        if (n == 0) return -1;
        int s = 0, e = n - 1;
        int sv = mountainArr.get(s);
        int ev = mountainArr.get(e);
        return binarySearch(s, e, sv, ev, target, mountainArr);
    }

    public int binarySearch(int si, int ei, int sv, int ev, int target, MountainArray nums) {
        if (sv == target) return si;
        if (target < sv && target < ev) return -1;
        if (ei - si > 1) {
            int mi = si + (ei - si) / 2;
            int mv = nums.get(mi);
            if (sv <= target && target < ev) {
                if (target <= mv) {
                    return binarySearch(si, mi, sv, mv, target, nums);
                } else {
                    return binarySearch(mi, ei, mv, ev, target, nums);
                }
            } else if (ev <= target && target < sv) {
                if (target < mv) {
                    return binarySearch(mi, ei, mv, ev, target, nums);
                } else {
                    return binarySearch(si, mi, sv, mv, target, nums);
                }
            } else {
                int index1 = binarySearch(si, mi, sv, mv, target, nums);
                if (index1 != -1) {
                    return index1;
                }
                return binarySearch(mi, ei, mv, ev, target, nums);
            }
        }

        if (ev == target) return ei;

        return -1;
   }
}
// @lc code=end

