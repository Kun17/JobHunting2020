/*
 * @lc app=leetcode id=878 lang=java
 *
 * [878] Nth Magical Number
 */

// @lc code=start
class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        int MOD  = 1000000007;
        int lcm = lcm(a, b);

        long s = 1L * Math.min(a, b);
        long e = 1L * Math.min(a, b) * n;

        while(e > s) {
            long mid = s + (e - s) / 2;
            if(totalNum(mid, a, b, lcm) >= n) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }

        return (int) (s % MOD);
    }

    public int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int totalNum(long cur, int a, int b, int lcm) {
        return (int) (cur / a) + (int) (cur / b) - (int) (cur / lcm);
    }
}
// @lc code=end

