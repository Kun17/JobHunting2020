/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int s = 1, e = n;
        while(e > s) {
            int mid = s + (e - s) / 2;
            if(isBadVersion(mid)) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }

        return s;
    }
}
// @lc code=end

