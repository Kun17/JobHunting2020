/*
 * @lc app=leetcode id=801 lang=java
 *
 * [801] Minimum Swaps To Make Sequences Increasing
 */

// @lc code=start
class Solution {
    boolean[] dp;
    public int minSwap(int[] A, int[] B) {
        int[] swap = new int[A.length];
        int[] notswap = new int[A.length];
        Arrays.fill(swap, Integer.MAX_VALUE);
        Arrays.fill(notswap, Integer.MAX_VALUE);
        swap[0] = 1;
        notswap[0] = 0;
        for (int i = 1; i < A.length; i++) {
            
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                swap[i] = swap[i - 1] + 1;
                notswap[i] = notswap[i - 1];
            }

            if (A[i] > B[ i -1] && B[i] > A[i - 1]) {
                swap[i] = Math.min(swap[i], notswap[i - 1] + 1);
                notswap[i] = Math.min(notswap[i], swap[i - 1]);
            }
        }

        return Math.min(swap[A.length - 1], notswap[A.length - 1]);
    }
}
// @lc code=end

