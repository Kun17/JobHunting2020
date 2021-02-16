/*
 * @lc app=leetcode id=735 lang=java
 *
 * [735] Asteroid Collision
 */

// @lc code=start
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(asteroids[0]);
        for(int i = 1; i < asteroids.length; i++) {
            int cur = asteroids[i];
            boolean exploded = false;
            while(stk.size() > 0 && cur < 0 && stk.peek() > 0) {
                if(Math.abs(cur) < Math.abs(stk.peek())) {
                    exploded = true;
                    break;
                } else if(Math.abs(cur) == Math.abs(stk.peek())) {
                    exploded = true;
                    stk.pop();
                    break;
                } else {
                    stk.pop();
                }
            }

            if(!exploded) {
                stk.push(cur);
            }
        }

        int[] ret = new int[stk.size()];
        for(int i = ret.length - 1; i >= 0; i--) {
            ret[i] = stk.pop();
        }

        return ret;
    }
}
// @lc code=end

