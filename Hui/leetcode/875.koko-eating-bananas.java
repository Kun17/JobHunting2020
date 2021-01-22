/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        long sum = 0;
        int e = 0; 
        for(int p: piles) {
            sum += p;
            e = Math.max(e, p);
        }

        int s = Math.max((int) (sum / H), 1);
        while(e > s) {
            int cur = s + (e - s) / 2;
            if(canEatAll(cur, piles, H)) {
                e = cur;
            } else {
                s = cur + 1;
            }
        }

        return (int) s;
    }

    public boolean canEatAll(int K, int[] ps, int H) {
        int count = 0;
        for(int p : ps) {
            count += p / K;
            if(p % K != 0) {
                count++;
            }
        }

        return count <= H;
    }
}
// @lc code=end

