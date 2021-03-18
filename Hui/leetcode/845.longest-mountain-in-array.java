
/*
 * @lc app=leetcode id=845 lang=java
 *
 * [845] Longest Mountain in Array
 */

// @lc code=start
class Solution {
    public int longestMountain(int[] arr) {
        int start = -1;
        int top = -1;
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            int prev = Integer.MAX_VALUE;
            if (i > 0) prev = arr[i - 1];
            int next = Integer.MAX_VALUE;
            if (i < arr.length - 1) next = arr[i + 1];

            if (prev >= arr[i] && next >= arr[i]) {
                if (start != - 1 && start < top && top < i) {
                    ret = Math.max(ret, i - start + 1);
                }
                start = i;
            } else if (prev < arr[i] && next < arr[i]){
                top = i;
            }
        }
        return ret;
    }
}
// @lc code=end

