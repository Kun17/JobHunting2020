/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> heap = new PriorityQueue<Point>((a, b) -> a.dist - b.dist);

        for(int[] p: points) {
            heap.add(new Point(p));
        }

        int[][] ret = new int[K][2];
        while(K > 0) {
            K--;
            ret[K] = heap.poll().point;
        }

        return ret;
    }

    class Point {
        int[] point;
        int dist;
        public Point(int[] point) {
            this.point = point;
            this.dist = point[0] * point[0] + point[1] * point[1];
        }
    }
}
// @lc code=end

