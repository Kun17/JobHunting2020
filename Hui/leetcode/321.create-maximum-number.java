/*
 * @lc app=leetcode id=321 lang=java
 *
 * [321] Create Maximum Number
 */

// @lc code=start
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ret = new int[k];
        for (int p = 0; p <= k; p++) {
            if (p > nums1.length || k - p > nums2.length) continue;
            int[] sub1 = getMax(nums1, p);
            int[] sub2 = getMax(nums2, k - p);

            int i = 0, j = 0;
            int[] subret = new int[k];
            int m = 0;
            while (i < sub1.length && j < sub2.length) {
                if (sub1[i] == sub2[j]) {
                    int t = 0;
                    while (i + t < sub1.length && j + t < sub2.length && sub1[i + t] == sub2[j + t]) {
                        t++;
                    }
                    int nexti = i + t < sub1.length? sub1[i + t]: Integer.MIN_VALUE;
                    int nextj = j + t < sub2.length? sub2[j + t]: Integer.MIN_VALUE;

                    if (nexti > nextj) {
                        subret[m++] = sub1[i++];
                    } else {
                        subret[m++] = sub2[j++];                  
                    }
                } else if (sub1[i] < sub2[j]) {
                    subret[m++] = sub2[j++];
                } else {
                    subret[m++] = sub1[i++];
                }
            }

            while (i < sub1.length) {
                subret[m++] = sub1[i++];
            }

            while (j < sub2.length) {
                subret[m++] = sub2[j++];
            }

            ret = max(ret, subret);
            // System.out.println(num);
        }

        return ret;
    }
    
    public int[] getMax(int[] nums, int k) {
        Stack<Integer> stk = new Stack<Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (stk.size() > 0 && stk.peek() < nums[i] && (n - i) + (stk.size() - 1) >= k) {
                stk.pop();
            }
            if (stk.size() < k) {
                stk.push(nums[i]);
            }
        }

        int[] ret = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ret[i] = stk.pop();
        }

        return ret;
    }

    public int[] max(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i]) {
                return a;
            } else if (a[i] < b[i]) {
                return b;
            }
        }
        return a;
    }
    // public long[] find(int[] nums, int k) {
    //     long[] dp = new long[k + 1];
    //     for (int i = 1; i <= nums.length; i++) {
    //         long[] next = new long[k + 1];
    //         for (int j = 1; j <= k; j++) {
    //             if (j > i) {
    //                 next[j] = -1;
    //             } else {
    //                 next[j] = Math.max(dp[j], dp[j - 1] * 10 + nums[i - 1]);
    //             }
    //         }
    //         dp = next;
    //     }
    //     // for (int j = 0; j <= k; j++) {
    //     //     System.out.println(j + " " + dp[j]);
    //     // }
    //     return dp;
    // }
    // [2,5,6,4,4,0]\n[7,3,8,0,6,5,7,6,2]\n15
    // [6,5,4,6,3,7,5,6,4,5,6,4]\n[8,8,6,0]\n16
    // [6,7,5]\n[4,8,1]\n3
}
// @lc code=end

