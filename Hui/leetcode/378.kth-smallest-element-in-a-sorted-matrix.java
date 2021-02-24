/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < matrix.length; i++) {
            heap.add(new int[]{i, 0, matrix[i][0]});
        }
        while (k > 1) {
            k--;
            int[] cur = heap.poll();
            if (cur[1] < matrix[cur[0]].length - 1) {
                heap.add(new int[]{cur[0], cur[1] + 1, matrix[cur[0]][cur[1] + 1]});
            }
        }

        return heap.poll()[2];
    }
}
// @lc code=end

