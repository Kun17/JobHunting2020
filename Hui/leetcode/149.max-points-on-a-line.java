/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1) return 1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            Map<Long, Integer> map = new HashMap<>();
            int duplicate = 0;
            int sameLine = 0;
            for (int j = i + 1; j < n; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                if (dx == 0 && dy == 0) {
                    duplicate++;
                    continue;
                }
                int gcd = gcd(dx, dy);
                int x = dx / gcd, y = dy / gcd;
                long hash = hash(x, y);
                if (map.containsKey(hash)) {
                    map.put(hash, map.get(hash) + 1);
                } else {
                    map.put(hash, 2);
                }
                sameLine = Math.max(sameLine, map.get(hash));
            }
            max = Math.max(max, sameLine + duplicate);
        }

        return max;
    }

    public long hash(long x, long y) {
        return (x << 32) ^ y;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
// @lc code=end

