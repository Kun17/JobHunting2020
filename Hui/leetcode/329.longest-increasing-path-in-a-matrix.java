/*
 * @lc app=leetcode id=329 lang=java
 *
 * [329] Longest Increasing Path in a Matrix
 */

// @lc code=start
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        Queue<int[]> q = new LinkedList<int[]>();
        int[][] d = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                d[i][j] = outDegree(matrix, i, j);
                if(d[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int dist = 0;
        while(q.size() > 0) {
            dist++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for(int[] dir : dirs) {
                    int[] next = new int[]{cur[0] + dir[0], cur[1] + dir[1]};
                    if(next[0] == -1 || next[0] == matrix.length || next[1] == -1 || next[1] == matrix[0].length || matrix[next[0]][next[1]] <= matrix[cur[0]][cur[1]]) {
                        continue;
                    }
                    if(--d[next[0]][next[1]] == 0) {
                        q.add(next);
                    }
                }
            }
        }

        return dist;
    }

    public int outDegree(int[][] m, int i, int j) {
        int degree = 0;
        if(i > 0 && m[i - 1][j] < m[i][j]) {
            degree++;
        }
        if(i < m.length - 1 && m[i + 1][j] < m[i][j]) {
            degree++;
        }
        if(j > 0 && m[i][j - 1] < m[i][j]) {
            degree++;
        }
        if(j < m[0].length - 1 && m[i][j + 1] < m[i][j]) {
            degree++;
        }
        return degree;
    }
    // [[0,1,2,3,4,5,6,7,8,9],[19,18,17,16,15,14,13,12,11,10],[20,21,22,23,24,25,26,27,28,29],[39,38,37,36,35,34,33,32,31,30],[40,41,42,43,44,45,46,47,48,49],[59,58,57,56,55,54,53,52,51,50],[60,61,62,63,64,65,66,67,68,69],[79,78,77,76,75,74,73,72,71,70],[80,81,82,83,84,85,86,87,88,89],[99,98,97,96,95,94,93,92,91,90],[100,101,102,103,104,105,106,107,108,109],[119,118,117,116,115,114,113,112,111,110],[120,121,122,123,124,125,126,127,128,129],[139,138,137,136,135,134,133,132,131,130],[0,0,0,0,0,0,0,0,0,0]]

 }
// @lc code=end

