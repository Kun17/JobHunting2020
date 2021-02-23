/*
 * @lc app=leetcode id=1383 lang=java
 *
 * [1383] Maximum Performance of a Team
 */

// @lc code=start
class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] eng = new int[n][2];
        for (int i = 0; i < n; i++) {
            eng[i] = new int[]{speed[i], efficiency[i]};
        }
        Arrays.sort(eng, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        long max = 0;
        long sum = 0;
        for (int[] e: eng) {
            if (heap.size() == k) {
                sum -= heap.poll();
            }
            heap.add(e[0]);
            sum += e[0];
            max = Math.max(max, sum * e[1]);
        }

        return (int) (max % 1000000007);
    }

    /*
    List<long[]>[][] memo;
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        memo = new List[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            memo[i][0] = new ArrayList<long[]>();
            memo[i][0].add(new long[]{0, Long.MAX_VALUE});
        }
        helper(n, speed, efficiency, 0, k);
        long max = 0;
        for (int i = 0; i <= k; i++) {
            if (memo[0][i] == null) continue;
            for (long[] r: memo[0][i]) {
                max = Math.max(max, r[0] * r[1]);
                // System.out.println(r[0] + "*" + r[1] + " = " + r[0] * r[1]);
            }
        }
        // for (List<long[]>[] lists: memo[0]) {
        //     for (List<long[]> list: lists) {
        //         for (long[] r: list) {
        //             max = Math.max(max, r[0] * r[1]);
        //             System.out.println(r[0] + "*" + r[1] + " = " + r[0] * r[1]); 
        //         }
        //     }
        // }
        // for (long[] r: ret) {
        //     max = Math.max(max, r[0] * r[1]);
        //     System.out.println(r[0] + " " + r[1]);
        // }
        return (int) (max % 1000000007);
    }

    public List<long[]> helper(int n, int[] s, int[] e, int i, int k) {
        // if (n - i < k) {
        //     return new ArrayList<long[]>();
        // }

        if (memo[i][k] != null) return memo[i][k];
        if (i == n) return memo[i][0];

        List<long[]> ret = new ArrayList<long[]>();
        // include this i
        List<long[]> nexts = helper(n, s, e, i + 1, k - 1);
        for (long[] next: nexts) {
            ret.add(new long[]{next[0] + s[i], Math.min(next[1], e[i])});
        }

        nexts = helper(n, s, e, i + 1, k);
        for (long[] next: nexts) {
            ret.add(next);
        }

        memo[i][k] = ret;
        return memo[i][k];
    }
    */
    // 3\n[2,8,2]\n[2,7,1]\n2
}
// @lc code=end

