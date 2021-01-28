/*
 * @lc app=leetcode id=1497 lang=java
 *
 * [1497] Check If Array Pairs Are Divisible by k
 */

// @lc code=start
class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] mod = new int[k];
        for(int num : arr) {
            int curMod = num % k < 0 ? num % k + k : num % k;

            if(curMod == 0) {
                mod[curMod] = (mod[curMod] + 1) % 2;
            } else if(mod[k - curMod] > 0) {
                mod[k - curMod]--;    
            } else {
                mod[curMod]++;
            }
        }
        
        for(int i = 0; i < k; i++) {
            if(mod[i] != 0) {
                return false;
            }
        }

//[-1,1,-2,2,-3,3,-4,4]\n3
        return true;
    }
}
// @lc code=end

