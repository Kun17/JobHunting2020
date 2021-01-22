/*
 * @lc app=leetcode id=658 lang=java
 *
 * [658] Find K Closest Elements
 */

// @lc code=start
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int s = 0, e = arr.length - 1;
        while(e - s > 1) {
            int mid = s + (e - s) / 2;
            if(arr[mid] - x <= 0) {
                s = mid;
            } else {
                e = mid;
            }
        }

        while(k > 0) {
            k--;
            int distS = Integer.MAX_VALUE;
            if(s >= 0) {
                distS = Math.abs(arr[s] - x);
            }
            int distE = Integer.MAX_VALUE;
            if(e < arr.length) {
                distE = Math.abs(arr[e] - x);
            }
            if(distS > distE) {
                e++;
            } else {
                s--;
            }
        }

        List<Integer> ret = new ArrayList<Integer>();
        for(int i = s + 1; i < e; i++) {
            ret.add(arr[i]);
        }

        if(ret.size() == 0) {
            ret.add(arr[0]);
        }
        return ret;
    }
}
// @lc code=end

