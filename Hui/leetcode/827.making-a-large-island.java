/*
 * @lc app=leetcode id=827 lang=java
 *
 * [827] Making A Large Island
 */

// @lc code=start
class Solution {
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] parent = new int[m * n];
        int[] weight = new int[m * n];
        Arrays.fill(parent, -1);
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int leftRoot = -1;
                    if (j > 0) {
                        leftRoot = find(parent, i * n + j - 1);
                    }
                    int upRoot = -1;
                    if (i > 0) {
                        upRoot = find(parent, (i - 1) * n + j);
                    }

                    parent[i * n + j] = i * n + j;
                    if (leftRoot == -1 && upRoot == -1) {
                        weight[i * n + j] = 1;
                    } else if (leftRoot == -1 && upRoot != -1) {
                        parent[upRoot] = i * n + j;
                        weight[i * n + j] = weight[upRoot] + 1;
                    } else if (leftRoot != -1 && upRoot == -1) {
                        parent[leftRoot] = i * n + j;
                        weight[i * n + j] = weight[leftRoot] + 1; 
                    } else if (leftRoot != upRoot) {
                        parent[leftRoot] = i * n + j;
                        parent[upRoot] = i * n + j;
                        weight[i * n + j] = weight[leftRoot] + weight[upRoot] + 1;
                    } else {
                        parent[leftRoot] = i * n + j;
                        weight[i * n + j] = weight[leftRoot] + 1; 
                    }

                    max = Math.max(max, weight[i * n + j]);
                }
            }
        }

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0,-1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int count = 1;
                    Set<Integer> set = new HashSet<Integer>();
                    for (int[] dir: dirs) {
                        int r = i + dir[0];
                        int c = j + dir[1];

                        if (r == -1 || r == m || c == -1 || c == n || grid[r][c] == 0) {
                            continue;
                        }

                        int root = find(parent, r * n + c);
                        if (root != -1 && !set.contains(root)) {
                            set.add(root);
                            count += weight[root];
                        }
                    }
                    max = Math.max(max, count);
                }
            }
        }

        return max;
    }

    public int find(int[] parent, int target) {
        if (parent[target] == -1) {
            return -1;
        }

        while(parent[target] != target) {
            parent[target] = parent[parent[target]];
            target = parent[target];
        }

        return target;
    }
}
// @lc code=end

