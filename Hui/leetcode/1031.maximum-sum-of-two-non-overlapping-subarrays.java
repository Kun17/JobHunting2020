/*
 * @lc app=leetcode id=1031 lang=java
 *
 * [1031] Maximum Sum of Two Non-Overlapping Subarrays
 */

// @lc code=start
class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int sumL = 0;
        for (int i = 0; i < L; i++) {
            sumL = sumL + A[i];
        }

        int[] maxL = new int[A.length];
        maxL[L - 1] = sumL;
        for (int i = L; i < A.length; i++) {
            sumL = sumL - A[i - L] + A[i];
            maxL[i] = Math.max(maxL[i - 1], sumL);
        }

        sumL = 0;
        for (int i = A.length - 1; i >= A.length - L; i--) {
            sumL = sumL + A[i];
        }
        int[] maxLReverse = new int[A.length];
        maxLReverse[A.length - L] = sumL;
        for (int i = A.length - L - 1; i >= 0; i--) {
            sumL = sumL - A[i + L] + A[i];
            maxLReverse[i] = Math.max(maxLReverse[i + 1], sumL);
        }

        int sumM = 0;
        for (int i = 0; i < M; i++) {
            sumM = sumM + A[i];
        }
        int ret = sumM + maxLReverse[M];
        for (int i = M; i < A.length; i++) {
            sumM = sumM - A[i - M] + A[i];
            if (L + M - 1 <= i) {
                ret = Math.max(ret, sumM + maxL[i - M]);
            }
            if (i <= A.length - L - 1) {
                ret = Math.max(ret, sumM + maxLReverse[i + 1]);
            }
        }

        return ret;
    }
    //[3,8,1,3,2,1,8,9,0]\n3\n2
    //[87,42,40,86,93,4,18,28,59,30,6,51,99,46,40,24,19,98,40,41]\n1\n10
}
// @lc code=end

