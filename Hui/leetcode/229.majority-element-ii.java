/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnta = 0;
        int cntb = 0;
        int a = 0;
        int b = 0;
        for (int num: nums) {
            if (num == a) {
                cnta++;
            } else if (num == b) {
                cntb++;
            } else if (cnta == 0) {
                a = num;
                cnta = 1;
            } else if (cntb == 0) {
                b = num;
                cntb = 1;
            } else {
                cnta--;
                cntb--;
            }
        }

        cnta = 0;
        cntb = 0;
        for (int num: nums) {
            if (num == a) {
                cnta++;
            } else if (num == b) {
                cntb++;
            }
        }
        List<Integer> ret = new ArrayList<Integer>();
        if (cnta > nums.length / 3) ret.add(a);
        if (cntb > nums.length / 3) ret.add(b);
        return ret;
    }
}
// @lc code=end

