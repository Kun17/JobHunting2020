/*
 * @lc app=leetcode id=223 lang=java
 *
 * [223] Rectangle Area
 */

// @lc code=start
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overlap = 0;
        if (C > E && G > A && D > F && H > B) {
            overlap = (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        } 

        return (C - A) * (D - B) + (G - E) * (H - F) - overlap; 
    }
}
// @lc code=end

