/*
 * @lc app=leetcode id=877 lang=java
 *
 * [877] Stone Game
 */

// @lc code=start
class Solution {
    public boolean stoneGame(int[] piles) {
        Arrays.sort(piles);
        int first = 0, second = 0;
        for(int i = 0; i < piles.length; i++) {
            if(i % 2 == 0) {
                first += piles[i];
            } else {
                second += piles[i];
            }
        }

        return second > first;
    }
}
// @lc code=end

