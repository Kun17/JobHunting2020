/*
 * @lc app=leetcode id=738 lang=java
 *
 * [738] Monotone Increasing Digits
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int N) {
        List<Integer> d = new ArrayList<Integer>();

        while(N != 0) {
            d.add(N % 10);
            N /= 10;
        }

        int firstNineIdx = -1;
        for(int i = 0; i < d.size() - 1; i++) {
            if(d.get(i) < d.get(i + 1)) {
                firstNineIdx = i;
                d.set(i + 1, d.get(i + 1) - 1);
            }
        }

        int ret = 0;
        for(int i = d.size() - 1; i >= 0; i--) {
            if(i <= firstNineIdx) {
                ret *= 10;
                ret += 9;
            } else {
                ret *= 10;
                ret += d.get(i);
            }
        }

        return ret;
    }
}
// @lc code=end

