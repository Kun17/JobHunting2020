/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
class Solution {
    List<List<Integer>> ret;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        ret = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return ret;
        int m = matrix.length, n = matrix[0].length;
        
        int[][] visited = new int[m][n];
        for (int i = 0; i < n; i++) {
            helper(0, i, visited, matrix, 1, Integer.MIN_VALUE);
        }

        for (int i = 1; i < m; i++) {
            helper(i, 0, visited, matrix, 1, Integer.MIN_VALUE);
        }

        for (int i = 0; i < n; i++) {
            helper(m - 1, i, visited, matrix, 2, Integer.MIN_VALUE);
        }

        for (int i = 0; i < m - 1; i++) {
            helper(i, n - 1, visited, matrix, 2, Integer.MIN_VALUE);
        }
        return ret;
    }

    public void helper(int i, int j, int[][] visited, int[][] matrix, int ocean, int prev) {
        if (i < 0 || i >= visited.length || j < 0 || j >= visited[0].length || matrix[i][j] < prev) return;
        if (visited[i][j] == ocean) return;
        if (visited[i][j] != 0) {
            ret.add(new ArrayList<>(Arrays.asList(i, j)));
        }

        visited[i][j] = ocean;
        helper(i + 1, j, visited, matrix, ocean, matrix[i][j]);
        helper(i, j + 1, visited, matrix, ocean, matrix[i][j]);
        helper(i - 1, j, visited, matrix, ocean, matrix[i][j]);
        helper(i, j - 1, visited, matrix, ocean, matrix[i][j]);
    }
}
// @lc code=end

